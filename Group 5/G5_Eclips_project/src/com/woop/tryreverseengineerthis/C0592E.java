package com.woop.tryreverseengineerthis;

import java.sql.Timestamp;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.woop.tryreverseengineerthis.E */
public class C0592E implements Runnable {
	private static C0592E L1L1;
	private AtomicInteger f5L;
	private ConcurrentLinkedQueue<String> L1;
	private Thread L1L;
	private boolean L1L1L;

	public static C0592E L1L1L1L1L1L1L() {
		if (L1L1 == null) {
			L1L1 = new C0592E();
		}
		return L1L1;
	}

	private C0592E() {
		this.f5L = new AtomicInteger(0);
		this.L1L1L = true;
		this.L1 = new ConcurrentLinkedQueue();
		this.L1L = new Thread(this);
		this.L1L.setDaemon(true);
		this.L1L.start();
	}

	private static boolean L1L1L1L1L1L1L1(int O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O) {
		if ((((double) O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O) / 2.0d) % 2.0d != 1.0d) {
			return true;
		}
		return false;
	}

	public void run() {
		while (true) {
			// if (C0592E.L1L1L1L1L1L1L1(1326)) {
			// C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
			// } else
			if (this.L1.size() == 0 || this.L1.peek() == null) {
				try {
					wait();
					this.L1L1L = true;
				} catch (InterruptedException e) {
				}
			}
			System.out.println((String) this.L1.poll());
		}
	}

	public void L1L1L1L1L1L1L1L() {
		this.f5L.getAndAdd(1);
		this.L1.add(new Timestamp(System.currentTimeMillis()).toString() + "\t\t" + "Class Status Satisfied.");
		// if (C0592E.L1L1L1L1L1L1L1(1230)) {
		// C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
		// } else
		if (this.L1L1L) {
			this.L1L1L = false;
			notify();
		}
	}
}
