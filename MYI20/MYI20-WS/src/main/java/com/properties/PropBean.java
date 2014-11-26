/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.properties;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author kishor
 */
@Component
public class PropBean {
    private static final Logger logger = Logger.getLogger(PropBean.class);
    private Map propData;

    /**
     *
     */
    public PropBean() {
        logger.info("prop bean object is created");

    }

    /**
     *
     * @return
     */
    public Map getPropData() {
        return propData;
    }

    /**
     *
     * @param propData
     */
    public void setPropData(Map propData) {
        this.propData = propData;
    }
}
