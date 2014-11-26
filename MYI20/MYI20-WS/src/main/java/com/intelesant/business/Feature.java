/*
 * To change this template,  choose Tools | Templates
 * and open the template in the editor.
 */
package com.intelesant.business;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


/**
 *
 * @author ramesh
 */
public class Feature implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5544068210092254096L;
    private Long id;
    private String featureGroup;
    private String featureName;
    private String viewTemplate;
    private Boolean showToView;
    private Set<Role> roles;
    private Boolean isMenuFeatures;

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id1
     */
    public void setId(Long id1) {
        this.id = id1;
    }

    /**
     *
     * @return
     */
    public String getFeatureName() {
        return featureName;
    }

    /**
     *
     * @param featureName1
     */
    public void setFeatureName(String featureName1) {
        this.featureName = featureName1;
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
     *
     * @return
     */
    public String getFeatureGroup() {
        return featureGroup;
    }

    /**
     *
     * @param featureGroup1
     */
    public void setFeatureGroup(String featureGroup1) {
        this.featureGroup = featureGroup1;
    }

    /**
     *
     * @return
     */
    public String getViewTemplate() {
        return viewTemplate;
    }

    /**
     *
     * @param viewTemplate1
     */
    public void setViewTemplate(String viewTemplate1) {
        this.viewTemplate = viewTemplate1;
    }

    /**
     *
     * @return
     */
    public Boolean getShowToView() {
        return showToView;
    }

    /**
     *
     * @param showToView1
     */
    public void setShowToView(Boolean showToView1) {
        this.showToView = showToView1;
    }

    public Boolean isIsMenuFeatures() {
        return isMenuFeatures;
    }

    public void setIsMenuFeatures(Boolean isMenuFeatures) {
        this.isMenuFeatures = isMenuFeatures;
    }

    
    @Override
    public String toString() {
        return "Feature{" + "id=" + id + ", featureName=" + featureName + '}';
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(
                1907,
                47).append(id)
                .hashCode();
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
        final Feature other = (Feature) obj;

        return new EqualsBuilder().append(id, other.id).isEquals();
    }
}