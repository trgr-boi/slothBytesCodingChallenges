package cui;

import java.util.Scanner;

public class CopyPaste {
	public static void main(String[] args) {
		CopyPaste instance = new CopyPaste();
        instance.start();
    }

    public void start() {
    	do {
    		String inputText = askInput();
    		if (inputText.equals("-q"))
    			break;
    		if (inputText.equals("-h"))
    			help();
    		if (!inputText.equals("-h") || !inputText.equals("-q")) {
    			String outputText = processCommands(inputText);
    			System.out.println("Output: " + outputText + "\n");
    		}
    	} while (true);
    	System.out.println("Thanks for checking this out! Made by TRGR-boi");
    }

    private String askInput() {
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        String text = null;
        boolean isValid = false;
        while(!isValid) {
        	System.out.print("Input (-h for help): ");
        	text = input.nextLine();
        	if(!text.isEmpty())
        		isValid= true;
        	if(text.isEmpty())
        		System.out.println("Input not valid");
        }
        return text;
    }

    private String processCommands(String inputText) {
        String copyCommand = "Ctrl + C";
        String pasteCommand = "Ctrl + V";
        StringBuilder result = new StringBuilder();
        String copiedText = "";

        int lastIndex = 0; // keep track of last position
        boolean copiedOnce = false;

        while(lastIndex < inputText.length()) {
        	int copyIndex = inputText.indexOf(copyCommand, lastIndex);
        	int pasteIndex = inputText.indexOf(pasteCommand, lastIndex);
        	
        	if(copyIndex != -1 && (pasteIndex == -1 || copyIndex < pasteIndex)) {
        		// append everything before "Ctrl + C" to result
        		result.append(inputText, lastIndex, copyIndex);
        		copiedText = result.toString().trim(); // save copied text
        		copiedOnce = true;
        		lastIndex = copyIndex + copyCommand.length(); // move past copy command
        	}
        	// if there is "Ctrl + V", append copiedText
        	else if(pasteIndex != -1) {
        		if(copiedOnce) {
        			result.append(copiedText).append("");
        		}
        		if(!copiedOnce) {
        			result.append(inputText, lastIndex, pasteIndex);
        			copiedText = result.toString().trim(); // save copied text
        		}
        		lastIndex = pasteIndex + pasteCommand.length(); // move past paste command
        	} else {
        		// if no command, add remaining text
        		result.append(inputText.substring(lastIndex));
        		break;
        	}
        }
        return result.toString().trim();
    }
    
    private void help() {
    	System.out.println("'Ctrl + C' to copy\n'Ctrl + V' to paste\n-q to exit\n");
    	return;
    }
}
