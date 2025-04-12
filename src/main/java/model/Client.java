package model;

/**
 * The Client class represents a client entity in the system.
 * This class stores information such as client's id, first name, second name, phone number and email.
 */
public class Client {
    private Integer id;
    private String firstName;
    private String lastName;
    private String numberOfPhone;
    private String email;

    // 0 = Woman
    // 1 = Man
    private int gender;

    public Client() {

    }

    /**
     * Returns the id of the client.
     * @return the id of the client
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id for the client.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the first name of the client.
     * @return the first name of the client
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name of the client.
     * @return the last name of the client
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the first name for the client.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the last name for the client.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the phone number for the client.
     * @param numberOfPhone
     */
    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    /**
     * Return the phone number of the client
     * @return the phone number of the client
     */
    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    /**
     * Return the email address of the client.
     * @return the email of the client.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address for the client
      * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return the gender of the client.
     * Gender is use for decide the photo in UI for the client
     * @return the gender of the client
     */
    public int getGender() {
        return gender;
    }

    /**
     * Set the id for client.
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Set the gender for a client
     * Gender is use for decide the photo in UI for the client
     * @param gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }
}
