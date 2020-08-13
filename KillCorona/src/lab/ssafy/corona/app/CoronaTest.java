package lab.ssafy.corona.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import lab.ssafy.corona.virus.Corona;

public class CoronaTest {

	public static void main(String[] args) {
		
		Corona c1 = new Corona("Corona5", 5, 5);
		Corona c2 = new Corona("Corona7", 5, 7);
		Corona c3 = new Corona("Corona3", 5, 3);
		Corona c4 = new Corona("Corona9", 5, 9);
		Corona c5 = new Corona("Corona1", 5, 1);
		
		PriorityQueue<Corona> pq = new PriorityQueue<>();
		pq.add(c1);
		pq.add(c2);
		pq.add(c3);
		pq.add(c4);
		pq.add(c5);
		
		Iterator<Corona> itr = pq.iterator();
		while(itr.hasNext()) System.out.println(itr.next());
		
		
		FakeVirus fv1 = new FakeVirus("fv1", 5);
		FakeVirus fv2 = new FakeVirus("fv2", 9);
		FakeVirus fv3 = new FakeVirus("fv3", 1);
		FakeVirus fv4 = new FakeVirus("fv4", 7);
		FakeVirus fv5 = new FakeVirus("fv5", 3);
		
		List<FakeVirus> list = new ArrayList<>();
		list.add(fv1);
		list.add(fv2);
		list.add(fv3);
		list.add(fv4);
		list.add(fv5);
		
		for( FakeVirus fv : list) System.out.println(fv);
		
		Collections.sort(list, new Comparator<FakeVirus>() {

			@Override
			public int compare(FakeVirus o1, FakeVirus o2) {
				return o1.level - o2.level;
			}
			
		});
		
		for( FakeVirus fv : list) System.out.println(fv);
	}
}
