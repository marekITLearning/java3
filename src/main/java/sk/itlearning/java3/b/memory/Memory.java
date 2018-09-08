package sk.itlearning.java3.b.memory;

public class Memory {

	public static void main(String[] args) {

		/*
		 * Returns the amount of free memory in the Java Virtual Machine.
		 * Returns an approximation to the total amount of memory currently
		 * available for future allocated objects, measured in bytes.
		 * Calling the gc method may result in increasing the value returned by freeMemory.
		 */
		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);

		Runtime.getRuntime().gc();

		System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024);

		/*
		 * Returns the total amount of memory in the Java virtual machine.
		 * The value returned by this method may vary over time, depending on the host environment.
		 */
		System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);

		// Returns the maximum amount of memory that the Java virtual machine will attempt to use.
		System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);

		System.out.println(Runtime.getRuntime().availableProcessors());

	}

}
