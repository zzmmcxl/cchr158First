package com.woop.tryreverseengineerthis;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.woop.tryreverseengineerthis.CourseList.courses;

/* renamed from: com.woop.tryreverseengineerthis.A */
public class C0926A extends Fragment {
	private static final String L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1 = "column-count";
	String L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L;
	private int L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L;
	private C0590B L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1;

	/* renamed from: com.woop.tryreverseengineerthis.A.B */
	public interface C0590B {
		void onListFragmentInteraction(courses c0593g);
	}

	public C0926A() {
		this.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L = "1117813965";
		this.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L = 1;
	}

	private static boolean L1L1L1L1L1L1L1(int i) {
		if ((((double) i) / 2.0d) % 2.0d != 1.0d) {
			return true;
		}
		return false;
	}

	public static C0926A m30x45336205(
			int O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O) {
		C0926A L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L = new C0926A();
		Bundle L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1 = new Bundle();
		L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1.putInt(
				L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1,
				O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O);
		L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L
				.setArguments(L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1);
		return L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L;
	}

	public void onCreate(Bundle b) {
		super.onCreate(b);
		// if (C0926A.L1L1L1L1L1L1L1(814)) {
		// C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
		// } else
		if (getArguments() != null) {
			this.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L = getArguments()
					.getInt(L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1);
		}
	}

	public View onCreateView(
			LayoutInflater O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O,
			ViewGroup O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1,
			Bundle O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1) {
		View L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1 = O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O
				.inflate(R.layout.fragment_universityclass_list,
						O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1O1, false);
		if (C0926A.L1L1L1L1L1L1L1(1226)) {
			C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
		} else if (L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1 instanceof RecyclerView) {
			Context L1L1L1L1L1L1L1L1 = L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1.getContext();
			RecyclerView L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L = (RecyclerView) L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1;
//			if (C0926A.L1L1L1L1L1L1L1(538)) {
//				C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
//			} else 
			if (this.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L <= 1) {
				L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L
						.setLayoutManager(new LinearLayoutManager(L1L1L1L1L1L1L1L1));
			} else {
				L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.setLayoutManager(new GridLayoutManager(
						L1L1L1L1L1L1L1L1, this.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L));
			}
			L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L.setAdapter(
					new C0928C(CourseList.courseList, this.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1));
		}
		return L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1;
	}

	public void onAttach(Context L1L1L1L1L1L1L1L1) {
		super.onAttach(L1L1L1L1L1L1L1L1);
		if (C0926A.L1L1L1L1L1L1L1(1086)) {
			C0592E.L1L1L1L1L1L1L().L1L1L1L1L1L1L1L();
		} else if (L1L1L1L1L1L1L1L1 instanceof C0590B) {
			this.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1 = (C0590B) L1L1L1L1L1L1L1L1;
		} else {
			throw new RuntimeException(L1L1L1L1L1L1L1L1.toString());
		}
	}

	public void onDetach() {
		super.onDetach();
		this.L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1L1 = null;
	}
}
