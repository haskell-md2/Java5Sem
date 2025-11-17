class Wrapper<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class One {
    public static void main(String[] args) {

        //1
        Wrapper<Integer> wrapperInt = new Wrapper<>();
        Wrapper<String> wrapperString = new Wrapper<>();

        System.out.println(wrapperInt instanceof Wrapper); // true
        System.out.println(wrapperString instanceof Wrapper); // true

        //2
        Object obj = wrapperInt; // obj ссылается на объект Wrapper<Integer>
        if (obj instanceof Wrapper<?>) {
            System.out.println("Это экземпляр Wrapper с произвольным типом");
        }

    }
}