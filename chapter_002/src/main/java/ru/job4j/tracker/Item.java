package ru.job4j.tracker;

import java.time.LocalDate;
import java.util.Objects;

/**
 * class item includes fields for class Tracker.
 */
public class Item {
    /**
     * id - id of client.
     */
    private String id;
    /**
     * name - name of client.
     */
    private String name;
    /**
     * desc - decription.
     */
    private String desc;
    /**
     * created - when it was created.
     */
    private LocalDate created;
    /**
     * comments.
     */
    private String[] comments;

    private Integer categoryId;

    private Integer user_id;

    /**
     * @param id      - id.
     * @param name    - name.
     * @param desc    - description.
     * @param created - time, when it was created.
     */
    public Item(String id, String name, String desc, LocalDate created, Integer category_id, Integer user_id) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.categoryId = category_id;
        this.user_id = user_id;
    }

    /**
     * empty constructor.
     */
    public Item() {

    }

    /**
     * @param name - name;
     * @param desc - description;
     * @param id   - id;
     */
    public Item(String name, String desc, String id) {
        this.name = name;
        this.desc = desc;
        this.id = id;
    }

    /**
     * @param id - received id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param name received name.
     *             Setter for name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return desc.
     */
    public String getDesc() {
        return this.desc;
    }


    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getUser_id() {
        return user_id;
    }


    /**
     * @return created.
     */
    public LocalDate getCreated() {
        return this.created;
    }

    /**
     * @return comments.
     */
    public String[] getComments() {
        return this.comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(desc, item.desc) &&
                Objects.equals(created, item.created) &&
                Objects.equals(categoryId, item.categoryId) &&
                Objects.equals(user_id, item.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created, categoryId, user_id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", created=" + created +
                ", categoryId=" + categoryId +
                ", user_id=" + user_id +
                '}';
    }
}
