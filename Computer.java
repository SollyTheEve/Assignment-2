package com.gmail.linganiso;

import java.text.DecimalFormat;

import com.gmail.slinganiso.NegativeValues;

/**
 *
 * @author Linganiso Solethu 219325561
 */
public class Computer {

    private String ipAddress;
    private float value;

    public Computer(String ipAddress, float value) {
        this.ipAddress = ipAddress;
        this.value = value;

    }

    public String getIPAddress() {
        return ipAddress;
    }

    public float getValue() {
        return value;
    }

    public void setIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setValue(float value) throws NegativeValues {
        
            this.value = value;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("$#,##0.00");
        return ipAddress + " " + decimalFormat.format(value )+ "\n";
    }
}

