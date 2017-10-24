package ru.job4j.tracker;
/**
*class item includes fields for class Tracker.
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
	private long created;
	/**
	*comments.
	*/
	private String[] comments;
	/**
	*@param id - id.
	*@param name - name.
	*@param desc - description.
	*@param created - time, when it was created.
	*/
	public Item(String id, String name, String desc, long created) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.created = created;
		this.comments = comments;
	}

	/**
	 * empty constructor.
	 */
	public Item() {

	}
	/**
	 *
	 * @param name - name;
	 * @param desc - description;
	 * @param id - id;
	 */
	public Item(String name, String desc, String id) {
		this.name = name;
		this.desc = desc;
		this.id = id;
	}

	/**
	*@param id - received id.
	*/
	public void setId(String id) {
		 this.id = id;
	}
	/**
	*@return id.
	*/
	public String getId() {
		return this.id;
	}
	/**
	 * @param name received name.
	 * Setter for name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	*@return name.
	*/
	public String getName() {
		return this.name;
	}
	/**
	*@return desc.
	*/
	public String getDesc() {
		return this.desc;
	}
	/**
	*@return created.
	*/
	public long getCreated() {
		return this.created;
	}
	/**
	*@return comments.
	*/
	public String[] getComments() {
		return this.comments;
	}
}
