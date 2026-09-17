import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;


void main() {
    OperatingSystemMXBean os =
            (OperatingSystemMXBean)
                    ManagementFactory.getOperatingSystemMXBean();
    while (true) {
        double cpu = os.getCpuLoad() * 100;

        long totalMemory = os.getTotalMemorySize() / 1000000;
        long freeMemory = os.getFreeMemorySize()/ 1000000;
        long usedMemory = totalMemory - freeMemory;

        double ramUsage = (double) usedMemory / totalMemory * 100;

        double load = os.getSystemLoadAverage();
        System.out.print("\033[H\033[2J");
        System.out.flush();

       // Runtime.getRuntime().exec("clear");
        System.out.printf("Cpu Usage: %f %% \n", cpu);
        System.out.printf("total Memory Usage: %d \n",  totalMemory);
        System.out.printf("Memory used: %d mb \n", usedMemory);
        System.out.printf("Available memory: %d mb \n", freeMemory);
        System.out.printf("ram usage %.2f %%\n", ramUsage);
        System.out.printf("Average number of executable processes %.2f \n", load);
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt(); // restore interrupted status
        }
    }


}
