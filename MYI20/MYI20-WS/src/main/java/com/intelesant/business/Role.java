/**
 *
 */
package com.intelesant.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


/**
 * @author rajashekar
 * 
 */
public class Role implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3930289318539998340L;
    private Long id;
    private String name;
    private RoleType roleType;
    private Set<Feature> features;
    private static final String CARE_HOME_MANAGER = "ROLE_CARE_HOME_MANAGER";
    private static final String INTELESANT_ADMIN = "ROLE_INTELESANT_ADMIN";
    private static final String GP_PRACTICE = "ROLE_GP_PRACTICE";
    private static final String FAMILY_MEMBER = "ROLE_FAMILY_MEMBER";
    private static final String DDO = "ROLE_DDO";
    private static final String ORGANIZATION_MEMBER ="ROLE_ORGANIZATION_MEMBER";
    private static final String ORGANIZATION_ADMIN ="ROLE_ORGANIZATION_ADMIN";
    /**
     *
     */
    public Role() {
    }

    /**
     * 
     * @param name1
     */
    public Role(String name1) {
        this.name = name1;
    }

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
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name1
     */
    public void setName(String name1) {
        this.name = name1;
    }

    /**
     * 
     * @return
     */
    public Set<Feature> getFeatures() {
        return features;
    }

    /**
     * 
     * @param features1
     */
    public void setFeatures(Set<Feature> features1) {
        this.features = features1;
    }

    /**
     * 
     * @return
     */
    public RoleType getRoleType() {
        return roleType;
    }

    /**
     * 
     * @param roleType1
     */
    public void setRoleType(RoleType roleType1) {
        this.roleType = roleType1;
    }

    /**
     * 
     * @return
     */
    public boolean isSystemRole() {
        return roleType.equals(RoleType.SYSTEM_ROLE);
    }

    /**
     * 
     * @return
     */
    public boolean isCareHomeManager() {
        return compareString(name, Role.CARE_HOME_MANAGER);
    }

    /**
     * 
     * @return
     */
    public boolean isGPPractice() {
        return compareString(name, Role.GP_PRACTICE);
    }

    /**
     * 
     * @return
     */
    public boolean isFamilyMember() {
        return compareString(name, Role.FAMILY_MEMBER);
    }

    /**
     * 
     * @return
     */
    public boolean isDDO() {
        return compareString(name, Role.DDO);
    }

    /**
     * 
     * @return
     */
    public boolean isIntelesantAdmin() {
        return compareString(name, Role.INTELESANT_ADMIN);
    }
    
     public boolean isOrgMemember() {
        return compareString(name, Role.ORGANIZATION_MEMBER);
    }
      public boolean isOrgAdmin() {
        return compareString(name, Role.ORGANIZATION_ADMIN);
    }

    /**
     * 
     * @param name1
     * @param name2
     * @return
     */
    public boolean compareString(String name1, String name2) {
        return name1.equalsIgnoreCase(name2);
    }

    /**
     * 
     * @return
     */
    
    public Map<String, List<String>> getFeaturesAsMap() {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        System.out.println("before features usning*******************************");
        for (Feature feature : features) {
            List<String> groupFeatures = (map.get(feature.getFeatureGroup()) == null) ? new ArrayList<String>()
                    : map.get(feature.getFeatureGroup());

            groupFeatures.add(feature.getFeatureName());

            map.put(feature.getFeatureGroup(), groupFeatures);
        }

        return map;

    }

    @Override
    public String toString() {
        return new StringBuilder().append("Role [id=").append(id)
                .append(", name=").append(name).append("]").toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(
                1899,
                53).append(id)
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
        Role other = (Role) obj;

        return new EqualsBuilder().append(this.name, other.name).isEquals();
    }
}