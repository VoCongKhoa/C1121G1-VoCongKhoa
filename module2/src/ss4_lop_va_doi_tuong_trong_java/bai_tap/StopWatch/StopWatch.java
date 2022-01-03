package ss4_lop_va_doi_tuong_trong_java.bai_tap.StopWatch;

import java.util.Random;

public class StopWatch {
    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void end() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    public static void selectionSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        StopWatch stopWatch = new StopWatch();
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = random.nextInt(500) - random.nextInt(500);
        }
        stopWatch.start();
        selectionSort(arr);
        stopWatch.end();

        System.out.println(stopWatch.getStartTime());
        System.out.println(stopWatch.getEndTime());
        System.out.println(stopWatch.getElapsedTime());
    }
}
