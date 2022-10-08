package lamba_expression;

@FunctionalInterface
public interface IPrintWritter {
    void printSomething();
}

@FunctionalInterface
interface ICalculable {
    int eval(int w, int h);
}

class App {
    public static void main(String[] args) {
        /*
         * Using lambda
         * */
        IPrintWritter ex = () -> System.out.println("Hello world using lambda expression impl");
        ex.printSomething();

        /*
         * Using Annonymous class
         * */
        IPrintWritter ex1 = new IPrintWritter() {
            @Override
            public void printSomething() {
                System.out.println("Hello world using Annonymous class impl");
            }
        };
        ex1.printSomething();

        /*
         * Using concrete class
         * */
        new PrintWritterImpl().printSomething();

        ICalculable rectangle = (w,h) -> 2 * (w + h);
        System.out.println(rectangle.eval(5,6));
    }
}

/*
 * Create concrete class
 * */
class PrintWritterImpl implements IPrintWritter {
    @Override
    public void printSomething() {
        System.out.println("Hello world using concrete class impl");
    }
}
