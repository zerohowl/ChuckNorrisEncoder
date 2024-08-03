package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (true) {

            System.out.println("Please input operation (encode/decode/exit):");
            String operation = scanner.nextLine();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                break;
            }

            else if (operation.equalsIgnoreCase("encode")) {
                System.out.println("Input string: ");
                String str = scanner.nextLine();
                char[] strArray = str.toCharArray();
                String formattedBinary = "";
                String result = "";


                System.out.println("Encoded String:");
                for (char thing : strArray)
                    formattedBinary += String.format("%07d", Integer.parseInt(Integer.toBinaryString(thing)));

                char[] formattedBinaryArray = formattedBinary.toCharArray();
                char currentChar = formattedBinaryArray[0];
                int count = 0;
                for (char c : formattedBinaryArray) {
                    if (c == currentChar)
                        count++;
                    else {
                        result += currentChar == '1' ? "0 " : "00 ";
                        for (int i = 0; i < count; i++) {
                            result += "0";
                            if (i == count - 1) result += " ";
                        }
                        count = 1;
                        currentChar = c;
                    }
                }
                result += currentChar == '1' ? "0 " : "00 ";
                for (int i = 0; i < count; i++) result += "0";
                System.out.println(result);

            } else if (operation.equalsIgnoreCase("decode")) {
                System.out.println("Input encoded string:");
                String encodedStr = scanner.nextLine();
                String[] encodedArray = encodedStr.split(" ");
                boolean isCount = false;
                int whiteSpaceCount = 0;
                String binary = "";
                String currentStr = "";
                int bitCount = 0;
                boolean isValid = true;

                for (String nextStr : encodedArray) {
                    if(encodedArray.length % 2 != 0) {
                        isValid = false;
                        break;
                    }
                    if (!isCount)
                        currentStr = nextStr;
                    else if (currentStr.equals("0"))
                        for (int i = 0; i < nextStr.length(); i++) {
                            if(nextStr.charAt(i) != '0') {
                                isValid = false;
                                break;
                            }
                            binary += "1";
                            if (++bitCount == 7) {
                                whiteSpaceCount++;
                                binary += " ";
                                bitCount = 0;
                            }
                        }
                    else if (currentStr.equals("00")) {
                        for (int i = 0; i < nextStr.length(); i++) {
                            if(nextStr.charAt(i) != '0') {
                                isValid = false;
                                break;
                            }
                            binary += "0";
                            if (++bitCount == 7) {
                                binary += " ";
                                whiteSpaceCount++;
                                bitCount = 0;
                            }
                        }
                    }
                    else {
                        isValid = false;
                        break;
                    }
                    isCount = !isCount;
                }
                if((binary.length()-whiteSpaceCount) % 7 != 0)
                    isValid = false;
                if(isValid) {
                    System.out.println("Decoded string:");
                    String[] binaryArray = binary.split(" ");
                    for (String bits : binaryArray) {
                        System.out.print((char) (Integer.parseInt(bits, 2)));
                    }
                    System.out.println();
                }
                else {
                    System.out.println("Encoded string is not valid.");
                    System.out.println();
                    continue;
                }

            } else {
                System.out.println("There is no '" + operation + "' operation");
            }
            System.out.println();

        }

        scanner.close();
    }
}