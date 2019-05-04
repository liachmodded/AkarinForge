/*
 * Akarin Forge
 */
package org.bukkit.craftbukkit.v1_12_R1;

public class TrigMath {
    static final double sq2p1 = 2.414213562373095;
    static final double sq2m1 = 0.41421356237309503;
    static final double p4 = 16.15364129822302;
    static final double p3 = 268.42548195503974;
    static final double p2 = 1153.029351540485;
    static final double p1 = 1780.406316433197;
    static final double p0 = 896.7859740366387;
    static final double q4 = 58.95697050844462;
    static final double q3 = 536.2653740312153;
    static final double q2 = 1666.7838148816338;
    static final double q1 = 2079.33497444541;
    static final double q0 = 896.7859740366387;
    static final double PIO2 = 1.5707963267948966;

    private static double mxatan(double arg2) {
        double argsq = arg2 * arg2;
        double value = (((16.15364129822302 * argsq + 268.42548195503974) * argsq + 1153.029351540485) * argsq + 1780.406316433197) * argsq + 896.7859740366387;
        return (value /= ((((argsq + 58.95697050844462) * argsq + 536.2653740312153) * argsq + 1666.7838148816338) * argsq + 2079.33497444541) * argsq + 896.7859740366387) * arg2;
    }

    private static double msatan(double arg2) {
        return arg2 < 0.41421356237309503 ? TrigMath.mxatan(arg2) : (arg2 > 2.414213562373095 ? 1.5707963267948966 - TrigMath.mxatan(1.0 / arg2) : 0.7853981633974483 + TrigMath.mxatan((arg2 - 1.0) / (arg2 + 1.0)));
    }

    public static double atan(double arg2) {
        return arg2 > 0.0 ? TrigMath.msatan(arg2) : - TrigMath.msatan(- arg2);
    }

    public static double atan2(double arg1, double arg2) {
        if (arg1 + arg2 == arg1) {
            return arg1 >= 0.0 ? 1.5707963267948966 : -1.5707963267948966;
        }
        arg1 = TrigMath.atan(arg1 / arg2);
        return arg2 < 0.0 ? (arg1 <= 0.0 ? arg1 + 3.141592653589793 : arg1 - 3.141592653589793) : arg1;
    }
}

