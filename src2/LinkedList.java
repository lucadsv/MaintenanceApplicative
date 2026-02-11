public class LinkedListCustom {

    private LNode head;
    private LNode tail;

    // === lst_create_list ===
    public LinkedListCustom() {
        head = null;
        tail = null;
    }

    // === lst_delete_list ===
    public void deleteList() {
        erase();
    }

    // === lst_insert_head ===
    public void insertHead(LNode node) {
        if (head == null) {
            head = tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
    }

    // === lst_insert_tail ===
    public void insertTail(LNode node) {
        if (tail == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }

    // === lst_insert_after ===
    public void insertAfter(LNode ptr, LNode node) {
        if (ptr == null) return;

        node.setPrev(ptr);
        node.setNext(ptr.getNext());

        if (ptr.getNext() != null) {
            ptr.getNext().setPrev(node);
        } else {
            tail = node;
        }

        ptr.setNext(node);
    }

    // === lst_delete_head ===
    public void deleteHead() {
        if (head == null) return;

        head = head.getNext();
        if (head != null) head.setPrev(null);
        else tail = null;
    }

    // === lst_delete_tail ===
    public void deleteTail() {
        if (tail == null) return;

        tail = tail.getPrev();
        if (tail != null) tail.setNext(null);
        else head = null;
    }

    // === lst_delete_lnode ===
    public void deleteNode(LNode node) {
        if (node == null) return;

        if (node == head) {
            deleteHead();
            return;
        }

        if (node == tail) {
            deleteTail();
            return;
        }

        LNode p = node.getPrev();
        LNode n = node.getNext();

        if (p != null) p.setNext(n);
        if (n != null) n.setPrev(p);
    }

    // === lst_erase ===
    public void erase() {
        head = null;
        tail = null;
    }

    // === get_first_node ===
    public LNode getFirstNode() {
        return head;
    }

    // === get_last_node ===
    public LNode getLastNode() {
        return tail;
    }

    // === get_next_node ===
    public LNode getNextNode(LNode node) {
        return node != null ? node.getNext() : null;
    }

    // === get_previous_elem ===
    public Object getPreviousElem(LNode node) {
        if (node != null && node.getPrev() != null) {
            return node.getPrev().getData();
        }
        return null;
    }
}
