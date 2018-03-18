package ru.job4j.exchangeglass;

import java.util.*;

public class ExchangeSystem {

    private Map<Integer, Glasses> securityPapersStore = new TreeMap<>();

    public Map<Integer, Glasses> getSecurityPapersStore() {
        return securityPapersStore;
    }

    /**
     * @param bookOfPaper - book of SecurityPaper.
     */
    public void addSecurityPaperToTheEchangeSystem(Integer bookOfPaper) {
        securityPapersStore.put(bookOfPaper, new Glasses());
    }

    /**
     * @param application - received application.
     * @return - boolean result of question: is this application belongs to
     */
    private boolean isApplicationBelongsToSomeGlass(Application application) {
        return securityPapersStore.containsKey(application.getBook());
    }

    /**
     * @param application - received application.
     * @return - boolean result. Belongs or not.
     */
    private boolean isApplicationBelongsToAskGlass(Application application) {
        return application.getAction().isAsk();
    }

    /**
     * @param application - received application.
     * @return - result of question: is this application has add type?
     */
    private boolean isApplicationHasAddType(Application application) {
        return application.getType().isAdd();
    }

    /**
     * add aplication to the ask glass. And sort glass with price from less to high.
     *
     * @param application - application, which will be add to the ask glass.
     */
    private void addToTheAskGlass(Application application) {
        securityPapersStore.get(application.getBook()).getAskGlass().add(application);
        securityPapersStore.get(application.getBook()).getAskGlass().sort(new Comparator<Application>() {
            @Override
            public int compare(Application application, Application t1) {
                return Integer.compare(t1.getPrice(), application.getPrice());
            }
        });
    }

    /**
     * Add application to the bid glass.
     *
     * @param application - application, which will be add to the bid glass.
     */
    private void enterTheAppToTheBidGlass(Application application) {
        securityPapersStore.get(application.getBook()).getBidGlass().add(application);


    }

    /**
     * Delete application from bidGlass.
     *
     * @param application - received application.
     */
    public void deleteApplicationFromBidGlass(Application application) {
        Integer key = application.getBook();
        securityPapersStore.get(key).getBidGlass().remove(application);
    }

    /**
     * Remove application from askGlass.
     *
     * @param application - received application.
     */
    private void removeAppFromAskGlass(Application application) {
        Integer key = application.getBook();
        securityPapersStore.get(key).getAskGlass().remove(application);
    }

    /**
     * Analysis for salesAction between of two application.
     *
     * @param fromBid - received bid application.
     * @param fromAsk - received ask application.
     * @return - boolean result of possible.
     */
    private boolean salesActionPossible(Application fromBid, Application fromAsk) {
        if (fromBid.getPrice() >= fromAsk.getPrice()) {
            if (fromBid.getVolume() >= fromAsk.getVolume()) {
                int tmp = fromBid.getVolume();
                fromBid.setVolume(fromBid.getVolume() - fromAsk.getVolume());
                fromAsk.setVolume(fromAsk.getVolume() - tmp);
                if (fromAsk.getVolume() <= 0) {
                    removeAppFromAskGlass(fromAsk);
                }
            } else {
                int tmp = fromAsk.getVolume();
                fromAsk.setVolume(fromAsk.getVolume() - fromBid.getVolume());
                fromBid.setVolume(fromBid.getVolume() - tmp);
                if (fromBid.getVolume() <= 0) {
                    deleteApplicationFromBidGlass(fromBid);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Method shows possibility in glasses to sale.
     *
     * @param application - received application to find a book of security paper.
     */
    public void analysGlassesForSalePossible(Application application) {
        boolean changed = false;
        List<Application> tmpBidGlass = securityPapersStore.get(application.getBook()).getBidGlass();
        List<Application> askGlassForOper = securityPapersStore.get(application.getBook()).getAskGlass();

        for (int i = 0; i < tmpBidGlass.size(); i++) {
            if (changed) {
                break;
            }
            for (int j = 0; j < askGlassForOper.size(); j++) {
                if (salesActionPossible(tmpBidGlass.get(i), askGlassForOper.get(j))) {
                    changed = true;
                    break;
                }
            }
        }

    }

    /**
     * @param glass - received glass.
     * @return - map with key - amount, value - price.
     */
    protected Map<Integer, Integer> fromGlassToMapWithCommonPrice(List<Application> glass) {
        Map<Integer, Integer> mapWithSamePriceAndCommonVolume = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return Integer.compare(t1, integer);
            }
        });

        for (Application application : glass) {
            if (mapWithSamePriceAndCommonVolume.containsKey(application.getPrice())) {
                mapWithSamePriceAndCommonVolume.put(application.getPrice(),
                        mapWithSamePriceAndCommonVolume.get(application.getPrice()) + application.getVolume());
            } else {
                mapWithSamePriceAndCommonVolume.put(application.getPrice(), application.getVolume());
            }
        }

        return mapWithSamePriceAndCommonVolume;

    }

    /**
     * print tradeProcess.
     *
     * @param valueOfPaperBook - value of security book.
     */
    public void printViewOfTradeInTheGlasses(Integer valueOfPaperBook) {
        Map<Integer, Integer> askGlassMap = fromGlassToMapWithCommonPrice(
                securityPapersStore.get(valueOfPaperBook).getAskGlass());

        List<Application> bidForPrintGlass =
                securityPapersStore.get(valueOfPaperBook).getBidGlass();
        Iterator<Application> applicationIterator = bidForPrintGlass.iterator();

        System.out.printf("%10s %10s %15s%n", "Продажа", "Цена", "Покупка");

        for (Map.Entry<Integer, Integer> entry : askGlassMap.entrySet()) {
            if (applicationIterator.hasNext()) {
                while (applicationIterator.hasNext()) {
                    System.out.printf("%8d %11d %13d %n", entry.getValue(), entry.getKey(), applicationIterator.next().getVolume());
                }
            } else {
                System.out.printf("%8d %11d %n", entry.getValue(), entry.getKey());
            }
        }

    }

    /**
     * @param application - received application.
     * @return - boolean result.
     */
    public boolean enterApplicationInTradeProcess(Application application) {
        if (isApplicationBelongsToSomeGlass(application)) {
            if (isApplicationBelongsToAskGlass(application)) {
                if (isApplicationHasAddType(application)) {
                    addToTheAskGlass(application);
                } else {
                    removeAppFromAskGlass(application);
                }
            } else {
                if (isApplicationHasAddType(application)) {
                    enterTheAppToTheBidGlass(application);
                } else {
                    deleteApplicationFromBidGlass(application);
                }
            }
            printViewOfTradeInTheGlasses(application.getBook());
            analysGlassesForSalePossible(application);
            printViewOfTradeInTheGlasses(application.getBook());

            return true;

        }
        return false;
    }

}

