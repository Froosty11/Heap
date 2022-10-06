public class Heap {
    LinkedList list;

    public Heap (){
        list = new LinkedList();
    }
    public void addLinear(Integer value){
        if(this.list.head == null){
            list.head = new Node(value);
            return;
        }
        if(this.list.head.data > value){
            Node newHead = new Node(value);
            newHead.next = this.list.head;
            this.list.head = newHead;
            return;
        }
        Node current = list.head;
        while(current.next != null){
            current = current.next;
            if(value <= current.data){
                break;
            }
        }
        Node temp = null;
        if(current.next != null){
            temp = current.next.next;
        }
        current.next = new Node(value);
        current.next.next = temp;
    }

    public Integer removeConstant(Node nodeBeforeTarget){
        Node t = nodeBeforeTarget.next.next;
        Integer value = nodeBeforeTarget.next.data;
        nodeBeforeTarget.next = t;
        return value;
    }
    public Integer removeLinear(Integer value){
        Node current = list.head;
        while(current.next != null && current.data != value){
            current = current.next;
        }
        Node t = current.next.next;
        Integer v = current.next.data;
        current.next = t;
        return v;
    }
}
