package com.mycompany.methotels.components;

import com.mycompany.methotels.data.Rates;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.Validate;

/**
 * To be updated (when I learn zone & ajax)
 * 
 * @author JOVANA
 */
public class RateComp {

    @Property
    @Persist
    @Validate("required")
    private Rates rates;
}
