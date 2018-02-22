import java.util.Scanner;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        // get initial dataset
        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter the initial sequence of values:");
        String inputtedList = kb.nextLine();
        String[] inputtedNums = inputtedList.split(" ");

        int[] numList = new int[inputtedNums.length];

        //parse Strings to Int
        for (int i = 0; i < numList.length; i++) {
            numList[i] = Integer.parseInt(inputtedNums[i]);
        }
        //create tree
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(numList[0]);

        for (int i : numList) {
            tree.add(i);
        }

        System.out.print("Pre-order: ");
        tree.preorderTraverse();
        System.out.println();
        System.out.print("In-order: ");
        tree.inorderTraverse();
        System.out.println();
        System.out.print("Post-order: ");
        tree.postorderTraverse();
        System.out.println();

        //run menu
        boolean running = true;
        while (running) {
            System.out.print("Command? ");
            String command = kb.next().toUpperCase();
            if (command.equals("I")) {
                Integer result = tree.add(kb.nextInt());
                if(result != null ) {
                    System.out.println(result + " already exists, ignore");
                }else{
                    System.out.print("In-order: ");
                    tree.inorderTraverse();
                    System.out.println();
                } 
            } else if (command.equals("D")) {
                tree.remove(kb.nextInt());
                System.out.print("In-order: ");
                tree.inorderTraverse();
                System.out.println();
            } else if (command.equals("P")) {
                System.out.println("predecessor: "+tree.getPredecessor(kb.nextInt()));
            } else if (command.equals("S")) {

            } else if (command.equals("E")) {
                System.out.println("Thank you for using my program!");
                return;
            } else if (command.equals("H")) {
                System.out.println("I Insert a value");
                System.out.println("D Delete a value");
                System.out.println("P Find predecessor");
                System.out.println("S Find successor");
                System.out.println("E Exit the program");
                System.out.println("H Display this message");
            } else {
                System.out.println("Invalid Command.");
            }
        }
    }
}