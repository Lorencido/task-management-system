public class Task {
    private String title;
    private boolean completion;

     public Task(String title) {
         this.title = title;
         this.completion = false;
     }

     public void completeTask() {
         this.completion = true;
    }

    public void printStatus() {
         if(completion) {
             System.out.println("Task: " + title + " is completed.");
         }
         else {
             System.out.println("Task: " + title + " is not completed.");
         }
    }
}
