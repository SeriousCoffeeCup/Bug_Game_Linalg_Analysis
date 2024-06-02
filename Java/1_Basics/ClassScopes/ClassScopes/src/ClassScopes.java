public class ClassScopes {
    public static void main(String[] args) {
        Greeting monday = new Greeting();
        monday.AM();
        monday.display();
        monday.PM();
        monday.display();
    }
}
class Greeting{//C++ wouldn't allow class higher to depend on class lower down, btw
    private String instanceVar = "Hello";
    public void AM() {
        String localVar = "Watch me disappear";
        instanceVar = "Good Morning!";
    }
    public void PM() {
        instanceVar = "Good Evening";
    }
    public void display() {
        System.out.println(instanceVar);
//        System.out.println(localvar); //It has disappeared o
    }

}


//Comparison to C++


//class MyClass {
//    public:    // Public access specifier
//    int x;   // Public attribute
//    private:   // Private access specifier
//    int y;   // Private attribute
//};
//
//int main() {
//    MyClass myObj;
//    myObj.x = 25;  // Allowed (public)
//    myObj.y = 50;  // Not allowed (private)
//    return 0;
//}