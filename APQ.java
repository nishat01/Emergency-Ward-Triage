dpackage A2Q2;

import java.util.*;

/**
 * Adaptible priority queue using location-aware entries in a min-heap, based on
 * an extendable array. The order in which equal entries were added is
 * preserved.
 * 
 * @author jameselder
 * @param <E>
 *            The entry type.
 */
public class APQ<E> {

	private final ArrayList<E> apq; // will store the min heap
	private final Comparator<E> comparator; // to compare the entries
	private final Locator<E> locator; // to locate the entries within the queue

	/**
	 * Constructor
	 * @param comparator
	 *            used to compare entries
	 * @param locator
	 *            used to locate the entries in the queue
	 * @throws NullPointerException
	 *             if comparator/locator parameters are null
	 */
	public APQ(Comparator<E> comparator, Locator<E> locator) throws NullPointerException {
		if (comparator == null || locator == null) {
			throw new NullPointerException();
		}
		apq = new ArrayList<>();
		apq.add(null); // dummy value at index = 0
		this.comparator = comparator;
		this.locator = locator;
	}
	/**
	 * Inserts the specified entry into this priority queue.
	 * @param e
	 *            the entry to insert
	 * @throws NullPointerException
	 *             if parameter e is null
	 */
	public void offer(E e) throws NullPointerException {
		if (e == null)
			throw new NullPointerException();
		this.apq.add(e);
		this.locator.set(e, this.size());
		this.upheap(this.size());
	}

	private int getLeftChildPos(int pos) {
		return pos * 2;
	}

	private int getRightChildPos(int pos) {
		return (pos * 2) + 1;
	}

	private int getParentPos(int pos) {
		return (int) Math.floor(pos / 2);
	}

	private boolean hasLeft(int pos) {
		return getLeftChildPos(pos) <= this.size();
	}

	private boolean hasright(int pos) {
		return getRightChildPos(pos) <= this.size();
	}

	private boolean hasParent(int pos) {
		return getParentPos(pos) > 0;
	}

	private E getLeftChild(int pos) {
		return this.apq.get(getLeftChildPos(pos));
	}

	private E getRightChild(int pos) {
		return this.apq.get(getRightChildPos(pos));
	}

	private E getParent(int pos) {
		return this.apq.get(getParentPos(pos));
	}
	/**
	 * Removes the entry at the specified location.
	 * @param pos
	 *            the location of the entry to remove
	 * @throws BoundaryViolationException
	 *             if pos is out of range
	 */
	public void remove(int pos) throws BoundaryViolationException {
		if (pos <= 0 || pos > this.size())
			throw new BoundaryViolationException();
		locator.set(apq.get(pos), 1);
		E e = this.apq.remove(size());
		if (pos <= size()) {
			this.apq.set(pos, e);
			this.locator.set(e, pos);
			if (this.hasParent(pos)
					&& comparator.compare(this.apq.get(pos),
							this.getParent(pos)) < 0) {
				this.upheap(pos);} 
			else
				downheap(pos);
		}
	}
	/**
	 * Removes the first entry in the priority queue.
	 */
	public E poll() {
		if (isEmpty()) {
			return null;
		}
		E result = this.apq.get(1)();
		try {
			this.remove(1);
		} catch (BoundaryViolationException e) {
			return null;
		}
		return result;
	}

	/**
	 * Returns but does not remove the first entry in the priority queue.
	 */
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return apq.get(1);
	}

	public boolean isEmpty() {
		return (size() == 0);
	}

	public int size() {
		return apq.size() - 1; // dummy node at location 0
	}

	/**
	 * Shift the entry at pos upward in the heap to restore the minheap property
	 * @param pos
	 *            the location of the entry to move
	 */
	private void upheap(int pos) {
		while (this.hasParent(pos)
				&& comparator.compare(apq.get(pos), this.getParent(pos)) < 0) {
			this.swap(pos, this.getParentPos(pos));
			pos = this.getParentPos(pos);
		}
	}

	/**
	 * Shift the entry at pos downward in the heap to restore the minheap property
	 * @param pos
	 *            the location of the entry to move
	 */
	private void downheap(int pos) {
		while (this.hasLeft(pos)) {
			if (this.hasright(pos)
					&& comparator.compare(this.getRightChild(pos),
							this.getLeftChild(pos)) < 0
					&& comparator.compare(this.getRightChild(pos),
							this.apq.get(pos)) < 0) {
				this.swap(pos, this.getRightChildPos(pos));
				pos = this.getRightChildPos(pos);
			} else if (comparator.compare(this.getLeftChild(pos),
					this.apq.get(pos)) < 0) {
				this.swap(pos, this.getLeftChildPos(pos));
				pos = this.getLeftChildPos(pos);
			} else
				break;
		}
	}

	/**
	 * Swaps the entries at the specified locations.
	 * @param pos1
	 *            the location of the first entry
	 * @param pos2
	 *            the location of the second entry
	 */
	private void swap(int pos1, int pos2) {
		E temp1 = this.apq.get(pos1);
		E temp2 = this.apq.get(pos2);

		this.apq.set(pos1, temp2);
		this.apq.set(pos2, temp1);

		this.locator.set(temp1, pos2);
		this.locator.set(temp2, pos1);

	}
}