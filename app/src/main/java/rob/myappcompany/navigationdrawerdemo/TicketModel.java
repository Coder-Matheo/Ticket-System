package rob.myappcompany.navigationdrawerdemo;

public class TicketModel {

    private String COLUM_ID;
    private String COLUM_CREATOR_NAME;
    private String COLUM_QUESTION_TICKET;
    private String COLUM_TICKET_NAME;
    private String COLUM_TITLE_CREATED;
    private String COLUM_SITUATION_TICKET;
    private String COLUM_PRIORITY_TICKET;
    private String COLUM_CREATED_DATE;
    private String COLUM_UPDATED_DATE;


    public TicketModel(String COLUM_ID, String COLUM_CREATOR_NAME, String COLUM_QUESTION_TICKET, String COLUM_TICKET_NAME, String COLUM_TITLE_CREATED, String COLUM_SITUATION_TICKET, String COLUM_PRIORITY_TICKET, String COLUM_CREATED_DATE, String COLUM_UPDATED_DATE) {
        this.COLUM_ID = COLUM_ID;
        this.COLUM_CREATOR_NAME = COLUM_CREATOR_NAME;
        this.COLUM_QUESTION_TICKET = COLUM_QUESTION_TICKET;
        this.COLUM_TICKET_NAME = COLUM_TICKET_NAME;
        this.COLUM_TITLE_CREATED = COLUM_TITLE_CREATED;
        this.COLUM_SITUATION_TICKET = COLUM_SITUATION_TICKET;
        this.COLUM_PRIORITY_TICKET = COLUM_PRIORITY_TICKET;
        this.COLUM_CREATED_DATE = COLUM_CREATED_DATE;
        this.COLUM_UPDATED_DATE = COLUM_UPDATED_DATE;
    }


    public String getCOLUM_ID() {
        return COLUM_ID;
    }

    public void setCOLUM_ID(String COLUM_ID) {
        this.COLUM_ID = COLUM_ID;
    }

    public String getCOLUM_CREATOR_NAME() {
        return COLUM_CREATOR_NAME;
    }

    public void setCOLUM_CREATOR_NAME(String COLUM_CREATOR_NAME) {
        this.COLUM_CREATOR_NAME = COLUM_CREATOR_NAME;
    }

    public String getCOLUM_QUESTION_TICKET() {
        return COLUM_QUESTION_TICKET;
    }

    public void setCOLUM_QUESTION_TICKET(String COLUM_QUESTION_TICKET) {
        this.COLUM_QUESTION_TICKET = COLUM_QUESTION_TICKET;
    }

    public String getCOLUM_TICKET_NAME() {
        return COLUM_TICKET_NAME;
    }

    public void setCOLUM_TICKET_NAME(String COLUM_TICKET_NAME) {
        this.COLUM_TICKET_NAME = COLUM_TICKET_NAME;
    }

    public String getCOLUM_TITLE_CREATED() {
        return COLUM_TITLE_CREATED;
    }

    public void setCOLUM_TITLE_CREATED(String COLUM_TITLE_CREATED) {
        this.COLUM_TITLE_CREATED = COLUM_TITLE_CREATED;
    }

    public String getCOLUM_SITUATION_TICKET() {
        return COLUM_SITUATION_TICKET;
    }

    public void setCOLUM_SITUATION_TICKET(String COLUM_SITUATION_TICKET) {
        this.COLUM_SITUATION_TICKET = COLUM_SITUATION_TICKET;
    }

    public String getCOLUM_PRIORITY_TICKET() {
        return COLUM_PRIORITY_TICKET;
    }

    public void setCOLUM_PRIORITY_TICKET(String COLUM_PRIORITY_TICKET) {
        this.COLUM_PRIORITY_TICKET = COLUM_PRIORITY_TICKET;
    }

    public String getCOLUM_CREATED_DATE() {
        return COLUM_CREATED_DATE;
    }

    public void setCOLUM_CREATED_DATE(String COLUM_CREATED_DATE) {
        this.COLUM_CREATED_DATE = COLUM_CREATED_DATE;
    }

    public String getCOLUM_UPDATED_DATE() {
        return COLUM_UPDATED_DATE;
    }

    public void setCOLUM_UPDATED_DATE(String COLUM_UPDATED_DATE) {
        this.COLUM_UPDATED_DATE = COLUM_UPDATED_DATE;
    }


}
