/*
 * To change this template,  choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.security;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author KITTU
 */
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 7014073361806793817L;
	private int userID;
	private String username;
	private String password;
	private Collection<GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private String salt;
	private static final Logger LOGGER = Logger.getLogger(CustomUserDetails.class);
	/**
     *
     */
    public CustomUserDetails() {

	}

	/**
     *
     * @param userID1
     * @param authorities1
     * @param username1
     * @param password1
     * @param accountNonExpired1
     * @param accountNonLocked1
     * @param credentialsNonExpired1
     * @param enabled1
     * @param salt1
     */
    public CustomUserDetails(int userID1,
			Collection<GrantedAuthority> authorities1, String username1,
			String password1, boolean accountNonExpired1,
			boolean accountNonLocked1, boolean credentialsNonExpired1,
			boolean enabled1, String salt1) {
		this.userID = userID1;
		this.authorities = authorities1;
		this.username = username1;
		this.password = password1;
		this.accountNonExpired = accountNonExpired1;
		this.accountNonLocked = accountNonLocked1;
		this.credentialsNonExpired = credentialsNonExpired1;
		this.enabled = enabled1;
		this.salt = salt1;
	}

	/**
     *
     * @param username1
     * @param password1
     * @param enabled1
     * @param accountNonExpired1
     * @param credentialsNonExpired1
     * @param accountNonLocked1
     * @param authorities1
     * @param salt1
     */
    public CustomUserDetails(String username1, String password1,
			boolean enabled1, boolean accountNonExpired1,
			boolean credentialsNonExpired1, boolean accountNonLocked1,
			Collection<GrantedAuthority> authorities1, String salt1) {

		this.authorities = authorities1;
		this.username = username1;
		this.password = password1;
		this.accountNonExpired = accountNonExpired1;
		this.accountNonLocked = accountNonLocked1;
		this.credentialsNonExpired = credentialsNonExpired1;
		this.enabled = enabled1;
		this.salt = salt1;

	}

	/**
     *
     * @return
     */
    public int getUserID() {
		return userID;
	}

	/**
     *
     * @param userID1
     */
    public void setUserID(int userID1) {
		this.userID = userID1;
	}

	/**
     *
     * @return
     */
    public String getUsername() {
		return username;
	}

	/**
     *
     * @param username1
     */
    public void setUsername(String username1) {
		this.username = username1;
	}

	/**
     *
     * @return
     */
    @Override
	public String getPassword() {
    	LOGGER.debug("get password" + password);
		return password;
	}

	/**
     *
     * @param password1
     */
    public void setPassword(String password1) {
    	LOGGER.debug(this.password);
	}

	/**
     *
     * @return
     */
    @Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
     *
     * @param authorities1
     */
    public void setAuthorities(Collection<GrantedAuthority> authorities1) {
		this.authorities = authorities1;
	}

	/**
     *
     * @return
     */
    @Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
     *
     * @param accountNonExpired1
     */
    public void setAccountNonExpired(boolean accountNonExpired1) {
		this.accountNonExpired = accountNonExpired1;
	}

	/**
     *
     * @return
     */
    @Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
     *
     * @param accountNonLocked1
     */
    public void setAccountNonLocked(boolean accountNonLocked1) {
		this.accountNonLocked = accountNonLocked1;
	}

	/**
     *
     * @return
     */
    @Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
     *
     * @param credentialsNonExpired1
     */
    public void setCredentialsNonExpired(boolean credentialsNonExpired1) {
		this.credentialsNonExpired = credentialsNonExpired1;
	}

	/**
     *
     * @return
     */
    @Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
     *
     * @param enabled1
     */
    public void setEnabled(boolean enabled1) {
		this.enabled = enabled1;
	}

	/**
     *
     * @return
     */
    public String getSalt() {
    	LOGGER.debug("get salt called from customeuserDetails" + salt);
		return salt;
	}

	/**
     *
     * @param salt1
     */
    public void setSalt(String salt1) {
		this.salt = salt1;
	}

}