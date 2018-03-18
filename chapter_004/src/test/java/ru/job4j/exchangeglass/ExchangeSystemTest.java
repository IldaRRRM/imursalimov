package ru.job4j.exchangeglass;

import org.junit.Test;
import ru.job4j.exchangeglass.applicationinnerclasses.Action;
import ru.job4j.exchangeglass.applicationinnerclasses.TypeOfApplication;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by ildar on 12.03.18.
 */
public class ExchangeSystemTest {
    @Test
    public void whenAddSecurityPaperToTheEchangeSystemTest() {
        ExchangeSystem exchangeSystem = new ExchangeSystem();
        exchangeSystem.addSecurityPaperToTheEchangeSystem(1);
        assertThat(exchangeSystem.getSecurityPapersStore().containsKey(1), is(true));
        assertThat(exchangeSystem.getSecurityPapersStore().containsKey(2), is(false));
    }

    @Test
    public void whenApplicationAddAndTradeProcessIsNotPossibleTest() {
        ExchangeSystem exchangeSystem = new ExchangeSystem();
        exchangeSystem.addSecurityPaperToTheEchangeSystem(1);
        Application firstAskApplication = new Application(4, new TypeOfApplication("add"), new Action("ask"), 70, 25);
        assertThat(exchangeSystem.enterApplicationInTradeProcess(firstAskApplication), is(false));
    }
    @Test
    public void whenAddedAThreeAskApplicationWithAddTypeAndTheyShouldSortedByPriceFromHighToLess() {
        ExchangeSystem exchangeSystem = new ExchangeSystem();
        exchangeSystem.addSecurityPaperToTheEchangeSystem(1);
        Application firstAskApplication = new Application(1, new TypeOfApplication("add"), new Action("ask"), 70, 25);
        Application secondAskAppl = new Application(1, new TypeOfApplication("add"), new Action("ask"), 20, 60);
        Application thirdAskApplication = new Application(1, new TypeOfApplication("add"), new Action("ask"), 150, 80);
        exchangeSystem.enterApplicationInTradeProcess(firstAskApplication);
        exchangeSystem.enterApplicationInTradeProcess(secondAskAppl);
        exchangeSystem.enterApplicationInTradeProcess(thirdAskApplication);
        assertThat(exchangeSystem.getSecurityPapersStore().get(1).getAskGlass().get(0), is(thirdAskApplication));
        assertThat(exchangeSystem.getSecurityPapersStore().get(1).getAskGlass().get(1), is(firstAskApplication));
    }
    @Test
    public void whenAddTwoAskApplicationWithAddTypeAndOneApplicationOfDeleteType() {
        ExchangeSystem exchangeSystem = new ExchangeSystem();
        exchangeSystem.addSecurityPaperToTheEchangeSystem(1);
        Application firstAskApplication = new Application(1, new TypeOfApplication("add"), new Action("ask"), 70, 25);
        Application secondAskAppl = new Application(1, new TypeOfApplication("add"), new Action("ask"), 20, 60);
        Application thirdAskApplicationWithDeleType = new Application(1, new TypeOfApplication("delete"), new Action("ask"), 20, 60);
        exchangeSystem.enterApplicationInTradeProcess(firstAskApplication);
        exchangeSystem.enterApplicationInTradeProcess(secondAskAppl);
        exchangeSystem.enterApplicationInTradeProcess(thirdAskApplicationWithDeleType);
        assertThat(exchangeSystem.getSecurityPapersStore().get(1).getAskGlass().size(), is(1));
    }

    @Test
    public void whenWeAddATwoAskAplicationWithAddTypeAndOneBidApplicationWithAddType() {
        ExchangeSystem exchangeSystem = new ExchangeSystem();
        exchangeSystem.addSecurityPaperToTheEchangeSystem(1);
        Application firstAskApplication = new Application(1, new TypeOfApplication("add"), new Action("ask"), 70, 25);
        Application secondAskAppl = new Application(1, new TypeOfApplication("add"), new Action("ask"), 20, 60);
        Application bidApplication = new Application(1, new TypeOfApplication("add"), new Action("Bid"), 20, 70);
        exchangeSystem.enterApplicationInTradeProcess(firstAskApplication);
        exchangeSystem.enterApplicationInTradeProcess(secondAskAppl);
        exchangeSystem.enterApplicationInTradeProcess(bidApplication);
        assertThat(exchangeSystem.getSecurityPapersStore().get(1).getAskGlass().size(), is(1));
        assertThat(exchangeSystem.getSecurityPapersStore().get(1).getBidGlass().get(0).getVolume(), is(10));

    }
    @Test
    public void whenWeAddBidApplicationAndTwoAskApplicationBidApplicaionShouldBeDeletedAfterEnteringInTradeProcess() {
        ExchangeSystem exchangeSystem = new ExchangeSystem();
        exchangeSystem.addSecurityPaperToTheEchangeSystem(1);
        Application firstAskApplication = new Application(1, new TypeOfApplication("add"), new Action("ask"), 70, 25);
        Application secondAskAppl = new Application(1, new TypeOfApplication("add"), new Action("ask"), 20, 60);
        Application bidApplication = new Application(1, new TypeOfApplication("add"), new Action("Bid"), 80, 15);
        exchangeSystem.enterApplicationInTradeProcess(firstAskApplication);
        exchangeSystem.enterApplicationInTradeProcess(secondAskAppl);
        exchangeSystem.enterApplicationInTradeProcess(bidApplication);
        assertThat(exchangeSystem.getSecurityPapersStore().get(1).getAskGlass().get(0).getVolume(), is(10));
        assertThat(exchangeSystem.getSecurityPapersStore().get(1).getAskGlass().size(), is(2));
        assertThat(exchangeSystem.getSecurityPapersStore().get(1).getBidGlass().size(), is(0));
    }
    @Test
    public void whenInAskGlassApplicationHaveSamePriceTheirVolumsShouldBeSummed() {
        ExchangeSystem exchangeSystem = new ExchangeSystem();
        exchangeSystem.addSecurityPaperToTheEchangeSystem(1);
        Application firstAskApplication = new Application(1, new TypeOfApplication("add"), new Action("ask"), 70, 25);
        Application secondAskAppl = new Application(1, new TypeOfApplication("add"), new Action("ask"), 70, 60);
        exchangeSystem.enterApplicationInTradeProcess(firstAskApplication);
        exchangeSystem.enterApplicationInTradeProcess(secondAskAppl);
        assertThat(exchangeSystem.fromGlassToMapWithCommonPrice(exchangeSystem.getSecurityPapersStore().get(1).getAskGlass()).get(70), is(85));
    }
}