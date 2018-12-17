package model;

public class Blog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.id
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.title
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.content
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog.author_id
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    private Long authorId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.id
     *
     * @return the value of blog.id
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.id
     *
     * @param id the value for blog.id
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.title
     *
     * @return the value of blog.title
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.title
     *
     * @param title the value for blog.title
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.content
     *
     * @return the value of blog.content
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.content
     *
     * @param content the value for blog.content
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog.author_id
     *
     * @return the value of blog.author_id
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    public Long getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog.author_id
     *
     * @param authorId the value for blog.author_id
     *
     * @mbggenerated Mon Dec 17 17:55:11 CST 2018
     */
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}