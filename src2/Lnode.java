public class LNode {

    private Object data;
    private LNode prev;
    private LNode next;

    // === lst_create_lnode ===
    public LNode(Object data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LNode getPrev() {
        return prev;
    }

    public void setPrev(LNode prev) {
        this.prev = prev;
    }

    public LNode getNext() {
        return next;
    }

    public void setNext(LNode next) {
        this.next = next;
    }
}
