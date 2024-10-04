import java.util.Scanner;

public class Main {
    private static final String EXIT_COMMAND = "exit";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите задание или введите '" + EXIT_COMMAND + "' для выхода:");
            System.out.println("1. Получение дробной части числа");
            System.out.println("2. Преобразование символа цифры в число");
            System.out.println("3. Проверка, является ли число двузначным");
            System.out.println("4. Проверка, входит ли число в диапазон");
            System.out.println("5. Проверка, равны ли три числа");
            System.out.println("6. Вычисление модуля числа");
            System.out.println("7. Проверка делимости числа на 3 или 5");
            System.out.println("8. Максмальное число их трех чисел");
            System.out.println("9. Сумма двух чисел");
            System.out.println("10. День недели по номеру");
            System.out.println("11. Числа подряд");
            System.out.println("12. Числа подряд четные");
            System.out.println("13. Длина числа");
            System.out.println("14. Квадрат звездочками");
            System.out.println("15. Правый треугольник");
            System.out.println("16. Поиск первого вхождения в массив");
            System.out.println("17. Поиск максимального с учетом модуля");
            System.out.println("18. Добавление массива в массив по индексу");
            System.out.println("19. Реверс массива");
            System.out.println("20. Все индексы вхождения значения в массиве");

            System.out.print("Введите номер задания или '" + EXIT_COMMAND + "': ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(EXIT_COMMAND)) {
                System.out.println("Выход из программы.");
                break;
            } else if (input.matches("\\d+")) { // Проверяем, является ли введенное строковое значение числом
                int taskNumber = Integer.parseInt(input); // Преобразуем строку в целое число

                switch (taskNumber) {
                    case 1:
                        double x;
                        while (true) {
                            System.out.println("Введите число для получения дробной части:");
                            if (scanner.hasNextDouble()) {
                                x = scanner.nextDouble();
                                scanner.nextLine(); // Очищаем буфер после ввода числа
                                break;
                            } else {
                                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                                scanner.nextLine(); // Очищаем буфер ввода
                            }
                        }
                        System.out.println("Дробная часть числа: " + fraction(x));
                        break;

                    case 2:
                        // Запрашиваем у пользователя ввод символа (цифры от '0' до '9').
                        System.out.print("Введите символ (цифру от '0' до '9'): ");
                        input = scanner.nextLine(); // Читаем ввод пользователя.

                        // Проверяем, что введен ровно один символ и он является цифрой.
                        if (input.length() == 1 && Character.isDigit(input.charAt(0))) {
                            char xChar = input.charAt(0); // Извлекаем первый (и единственный) символ из ввода.
                            int num = charToNum(xChar); // Преобразуем символ в его числовое значение с помощью функции charToNum.
                            // Выводим числовое значение символа на экран.
                            System.out.println("Числовое значение символа '" + xChar + "': " + num);
                        } else {
                            // Если ввод некорректен, выводим сообщение об ошибке.
                            System.out.println("Ошибка: введенный символ не является цифрой или введено несколько символов.");
                        }
                        break;

                    case 3:
                        int number = getIntegerInput(scanner, "Введите целое число для проверки, является ли оно двузначным:");
                        if (is2Digits(number)) {
                            System.out.println("Число " + number + " является двузначным.");
                        } else {
                            System.out.println("Число " + number + " не является двузначным.");
                        }
                        break;

                    case 4:
                        int a = getIntegerInput(scanner, "Введите левую границу диапазона:");
                        int b = getIntegerInput(scanner, "Введите правую границу диапазона:");
                        int num = getIntegerInput(scanner, "Введите число для проверки:");

                        if (isInRange(a, b, num)) {
                            System.out.println("Число " + num + " входит в диапазон [" + a + ", " + b + "].");
                        } else {
                            System.out.println("Число " + num + " не входит в диапазон [" + a + ", " + b + "].");
                        }
                        break;

                    case 5:
                        int first = getIntegerInput(scanner, "Введите первое число:");
                        int second = getIntegerInput(scanner, "Введите второе число:");
                        int third = getIntegerInput(scanner, "Введите третье число:");

                        if (isEqual(first, second, third)) {
                            System.out.println("Все три числа равны.");
                        } else {
                            System.out.println("Числа не равны.");
                        }
                        break;

                    case 6:
                        int number6 = getIntegerInput(scanner, "Введите целое число для вычисления модуля:");
                        System.out.println("Модуль числа " + number6 + " равен " + absoluteValue(number6));
                        break;

                    case 7:
                        int number7 = getIntegerInput(scanner, "Введите целое число для проверки делимости на 3 или 5:");
                        if (is35(number7)) {
                            System.out.println("Число " + number7 + " делится нацело на 3 или 5.");
                        } else {
                            System.out.println("Число " + number7 + " не делится нацело на 3 или 5, или делится на оба.");
                        }
                        break;

                    case 8:
                        int num8_1 = getIntegerInput(scanner, "Введите первое целое число: ");
                        int num8_2 = getIntegerInput(scanner, "Введите второе целое число: ");
                        int num8_3 = getIntegerInput(scanner, "Введите третье целое число: ");
                        int maximum = max3(num8_1, num8_2, num8_3);
                        System.out.println("Максимальное из трех чисел: " + maximum);
                        break;

                    case 9:
                        int num9_1 = getIntegerInput(scanner, "Введите первое целое число: ");
                        int num9_2 = getIntegerInput(scanner, "Введите второе целое число: ");
                        int result = sum2(num9_1, num9_2);
                        System.out.println("Результат: " + result);
                        break;

                    case 10:
                        int dayNumber = getIntegerInput(scanner, "Введите число, обозначающее день недели (1-7): ");
                        String dayOfWeek = day(dayNumber);
                        System.out.println("День недели: " + dayOfWeek);
                        break;

                    case 11:
                        int maxNum = getIntegerInput(scanner, "Введите целое число: ");
                        String numbers = listNums(maxNum);
                        System.out.println("Числа от 0 до " + maxNum + ": " + numbers);
                        break;

                    case 12:
                        int Num12 = getIntegerInput(scanner, "Введите целое число: ");
                        String evenNumbers = chet(Num12);
                        System.out.println("Четные числа от 0 до " + Num12 + ": " + evenNumbers);
                        break;

                    case 13:
                        System.out.print("Введите число типа long: ");
                        long longNumber = scanner.nextLong(); // Вводим число типа long
                        int length = numLen(longNumber);
                        System.out.println("Количество цифр в числе " + longNumber + ": " + length);
                        scanner.nextLine(); // Очищаем буфер ввода
                        break;

                    case 14:
                        int size = getIntegerInput(scanner, "Введите целое число для размера квадрата: ");
                        square(size);
                        break;

                    case 15:
                        int height = getIntegerInput(scanner, "Введите целое число для высоты треугольника: ");
                        rightTriangle(height);
                        break;

                    case 16:
                        int size16 = getPositiveIntegerInput(scanner, "Введите размер массива: ");
                        int[] arr = new int[size16];
                        for (int i = 0; i < size16; i++) {
                            arr[i] = getIntegerInput(scanner, "Введите элемент массива " + (i + 1) + ": ");
                        }

                        int x16 = getIntegerInput(scanner, "Введите число для поиска: ");
                        int index = findFirst(arr, x16);
                        if (index != -1) {
                            System.out.println("Первое вхождение числа " + x16 + " находится по индексу: " + index);
                        } else {
                            System.out.println("Число " + x16 + " не найдено в массиве.");
                        }
                        break;


                    case 17:
                        int size17 = getPositiveIntegerInput(scanner, "Введите размер массива: ");
                        int[] arr17 = new int[size17];
                        for (int i = 0; i < size17; i++) {
                            arr17[i] = getIntegerInput(scanner, "Введите элемент массива " + (i + 1) + ": ");
                        }

                        int maxValue = maxAbs(arr17);
                        System.out.println("Максимальное по модулю значение в массиве: " + maxValue);
                        break;

                    case 18:
                        int sizeArr = getPositiveIntegerInput(scanner, "Введите размер первого массива: ");
                        int[] arr18 = new int[sizeArr];
                        for (int i = 0; i < sizeArr; i++) {
                            arr18[i] = getIntegerInput(scanner, "Введите элемент первого массива " + (i + 1) + ": ");
                        }

                        int sizeIns = getPositiveIntegerInput(scanner, "Введите размер массива для вставки: ");
                        int[] ins = new int[sizeIns];
                        for (int i = 0; i < sizeIns; i++) {
                            ins[i] = getIntegerInput(scanner, "Введите элемент массива для вставки " + (i + 1) + ": ");
                        }

                        int pos = getIntegerInput(scanner, "Введите позицию для вставки: ");
                        // Проверяем корректность позиции
                        if (pos < 0 || pos > arr18.length) {
                            System.out.println("Некорректная позиция для вставки.");
                        } else {
                            int[] result18 = add(arr18, ins, pos);
                            System.out.print("Результирующий массив: [");
                            for (int i = 0; i < result18.length; i++) {
                                System.out.print(result18[i]);
                                if (i < result18.length - 1) {
                                    System.out.print(", ");
                                }
                            }
                            System.out.println("]");
                        }
                        break;

                    case 19:
                        int size19 = getPositiveIntegerInput(scanner, "Введите размер массива: ");
                        int[] arr19 = new int[size19];
                        for (int i = 0; i < size19; i++) {
                            arr19[i] = getIntegerInput(scanner, "Введите элемент массива " + (i + 1) + ": ");
                        }
                        int[] reversedArr = reverseBack(arr19);

                        System.out.print("Реверсированный массив: [");
                        for (int i = 0; i < reversedArr.length; i++) {
                            System.out.print(reversedArr[i]);
                            if (i < reversedArr.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("]");
                        break;

                    case 20:
                        int size20 = getPositiveIntegerInput(scanner, "Введите размер массива: ");
                        int[] arr20 = new int[size20];
                        for (int i = 0; i < size20; i++) {
                            arr20[i] = getIntegerInput(scanner, "Введите элемент массива " + (i + 1) + ": ");
                        }

                        int x20 = getIntegerInput(scanner, "Введите число для поиска: ");
                        int[] indices = findAll(arr20, x20);
                        if (indices.length == 0) {
                            System.out.println("Число " + x20 + " не найдено в массиве.");
                        } else {
                            System.out.print("Индексы всех вхождений числа " + x20 + ": [");
                            for (int i = 0; i < indices.length; i++) {
                                System.out.print(indices[i]);
                                if (i < indices.length - 1) {
                                    System.out.print(", ");
                                }
                            }
                            System.out.println("]");
                        }
                        break;

                    default:
                        System.out.println("Некорректный номер задания. Попробуйте снова.");
                        break;


                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите номер задания или '" + EXIT_COMMAND + "'.");
            }
        }
        scanner.close();
    }


    public static int getIntegerInput(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // Очищаем буфер после ввода числа
                break; // Прерываем цикл, если ввод корректный
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
                scanner.nextLine(); // Очищаем буфер ввода
            }
        }
        return number;
    }

    public static int getPositiveIntegerInput(Scanner scanner, String prompt) {
        int number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine(); // Очищаем буфер после ввода числа
                if (number > 0) {
                    break; // Прерываем цикл, если число положительное
                } else {
                    System.out.println("Некорректный ввод. Размер массива должен быть положительным числом.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое положительное число.");
                scanner.nextLine(); // Очищаем буфер ввода
            }
        }
        return number;
    }

    public static double fraction(double x) {
        return x - (int) x;
    }

    public static int charToNum(char x) {
        return x - '0';
    }

    public static boolean is2Digits(int x) {
        return (x >= 10 && x <= 99) || (x <= -10 && x >= -99);
    }

    public static boolean isInRange(int a, int b, int num) {
        int lowerBound = Math.min(a, b);
        int upperBound = Math.max(a, b);
        return num >= lowerBound && num <= upperBound;
    }

    public static boolean isEqual(int a, int b, int c) {
        return (a == b) && (b == c);
    }

    public static int absoluteValue(int x) {
        return (x < 0) ? -x : x;
    }

    public static boolean is35(int x) {
        return (x % 3 == 0 || x % 5 == 0) && !(x % 3 == 0 && x % 5 == 0);
    }

    public static int max3(int x, int y, int z) {
        int max = (x > y) ? x : y; // Находим максимум между x и y
        return (max > z) ? max : z; // Сравниваем найденный максимум с z и возвращаем наибольшее значение
    }

    public static int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) {
            return 20;
        } else {
            return sum;
        }
    }

    public static String day(int x) {
        return switch (x) {
            case 1 -> "Понедельник";
            case 2 -> "Вторник";
            case 3 -> "Среда";
            case 4 -> "Четверг";
            case 5 -> "Пятница";
            case 6 -> "Суббота";
            case 7 -> "Воскресенье";
            default -> "Это не день недели";
        };
    }

    public static String listNums(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i++) {
            result.append(i).append(" ");
        }
        return result.toString().trim();
    }

    public static String chet(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i += 2) {
            result.append(i).append(" ");
        }
        return result.toString().trim(); // Убираем лишний пробел в конце
    }

    public static int numLen(long x) {
        int length = 0;
        if (x == 0) {
            return 1;
        }
        while (x != 0) {
            x /= 10;
            length++;
        }
        return length;
    }

    public static void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println(); // Переходим на следующую строку после вывода ряда символов
        }
    }

    public static void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int maxAbs(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(max)) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }
        // Копируем оставшиеся элементы оригинального массива
        for (int i = pos; i < arr.length; i++) {
            result[ins.length + i] = arr[i];
        }
        return result; // Возвращаем новый массив
    }


    public static int[] reverseBack(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int value : arr) {
            if (value == x) {
                count++;
            }
        }

        int[] indices = new int[count];
        int index = 0; // Индекс для нового массива
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                indices[index++] = i; // Сохраняем индекс вхождения
            }
        }
        return indices;
    }
}
