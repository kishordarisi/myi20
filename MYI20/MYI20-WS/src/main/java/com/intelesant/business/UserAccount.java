/**
 *
 */
package com.intelesant.business;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


/**
 * @author rajashekar
 *
 */
public class UserAccount implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8719705932814813721L;
    private String id;
    private String password;
    private Boolean enabled;
    private Set<Role> roles;
    private Boolean intelesantUser;
    private Integer loginAttempt;
    private Boolean accountNotLocked;
   
    
    private String firstName;
	private String lastName;
	private String userName;
        private String mobileNumber;
        private String promoCode;
	private String comments;
	private String country;
    
    public UserAccount() {
        this.roles = new HashSet<Role>();
    }

    /**
     *
     * @param userName1
     * @param password1
     * @param enabled1
     */
    public UserAccount(String userName1, String password1, Boolean enabled1) {
        this.userName = userName1;
        this.password = password1;
        this.enabled = enabled1;
        this.roles = new HashSet<Role>();
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id1
     */
    public void setId(String id1) {
        this.id = id1;
    }


    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password1
     */
    public void setPassword(String password1) {
        this.password = password1;
    }

    /**
     *
     * @return
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled1
     */
    public void setEnabled(Boolean enabled1) {
        this.enabled = enabled1;
    }

    /**
     *
     * @return
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     *
     * @param roles1
     */
    public void setRoles(Set<Role> roles1) {
        this.roles = roles1;
    }

    /**
     * @return the intelesantUser
     */
    public Boolean getIntelesantUser() {
        return intelesantUser;
    }

    /**
     *
     * @param intelesantUser1
     */
    public void setIntelesantUser(Boolean intelesantUser1) {
        this.intelesantUser = intelesantUser1;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
    /**
     *
     * @return
     */
    public Integer getLoginAttempt() {
        return loginAttempt;
    }

    /**
     *
     * @param loginAttempt1
     */
    public void setLoginAttempt(Integer loginAttempt1) {
        this.loginAttempt = loginAttempt1;
    }

    /**
     *
     * @return
     */
    public Boolean getAccountNotLocked() {
        return accountNotLocked;
    }

    /**
     *
     * @param accountNotLocked1
     */
    public void setAccountNotLocked(Boolean accountNotLocked1) {
        this.accountNotLocked = accountNotLocked1;
    }
  

    @Override
    public int hashCode() {
        return new HashCodeBuilder(
                1897,
                31)
                .append(userName).hashCode();
    }


    public Boolean isEnabled() {
        return enabled;
    }

    public Boolean isIntelesantUser() {
        return intelesantUser;
    }

    public Boolean isAccountNotLocked() {
        return accountNotLocked;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserAccount other = (UserAccount) obj;

        return new EqualsBuilder().append(userName, other.userName).isEquals();
    }
}