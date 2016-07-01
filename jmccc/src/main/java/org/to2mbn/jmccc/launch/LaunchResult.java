package org.to2mbn.jmccc.launch;

import org.to2mbn.jmccc.exec.ProcessMonitor;

/**
 * The result of launching.
 */
public class LaunchResult {

	private ProcessMonitor monitor;
	private Process process;

	public LaunchResult(ProcessMonitor monitor, Process process) {
		this.monitor = monitor;
		this.process = process;
	}

	/**
	 * Gets the process monitor.
	 * <p>
	 * We recommend you not to call {@link ProcessMonitor#stop()}. This may
	 * cause the subprocess to be blocked (because the buffers of stdout and
	 * stderr may become full), and it's not always effective.
	 * 
	 * @return the process monitor
	 */
	public ProcessMonitor getMonitor() {
		return monitor;
	}

	/**
	 * Gets the game process.
	 * 
	 * @return the game process
	 */
	public Process getProcess() {
		return process;
	}

}
