package takinoue.missionstatement.bean;

/**
 * MISSION_STATEMENTテーブルのbeanクラス.
 */
public class MissionStatementBean {

    /** ID */
    private int id;

    /** CATEGORY_ID */
    private int categoryId;

    /** 文言 */
    private String words;

    /** 人名 */
    private String person;

    /** 人名 */
    private String registDate;

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id セットする id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId セットする categoryId
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return registDate
     */
    public String getRegistDate() {
        return registDate;
    }

    /**
     * @param registDate セットする registDate
     */
    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    /**
     * 文言を返す.
     * @return words
     */
    public String getWords() {
        return words;
    }

    /**
     * 文言をセットする.
     * @param words セットする words
     */
    public void setWords(String words) {
        this.words = words;
    }

    /**
     * 人名を返す.
     * @return person
     */
    public String getPerson() {
        return person;
    }

    /**
     * 人名をセットする.
     * @param person セットする person
     */
    public void setPerson(String person) {
        this.person = person;
    }
}