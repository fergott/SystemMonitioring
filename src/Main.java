import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


void main() {
    OperatingSystemMXBean os =
            (OperatingSystemMXBean)
                    ManagementFactory.getOperatingSystemMXBean();
    while (true) {
    double cpu = os.getCpuLoad() * 100;

    long totalMemory = os.getTotalMemorySize();
    long freeMemory = os.getFreeMemorySize();
    long usedMemory = totalMemory - freeMemory;

        double ramUsage = (double) usedMemory / totalMemory * 100;

        double load = os.getSystemLoadAverage();

        System.out.flush();

        System.out.println("Cpu Usage: " + cpu);
        System.out.println("total Memory Usage: " + totalMemory);
        System.out.println("Memory used: " + usedMemory);
        System.out.printf("percent of ram used %.2f \n", ramUsage);
        System.out.printf("total load %.2f", load);

        Thread.sleep(1000);
    }
}
