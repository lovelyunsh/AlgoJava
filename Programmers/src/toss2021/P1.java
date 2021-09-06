package toss2021;

public class P1 {
    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        long answer = (long)Math.ceil((1d*orderAmount - serviceFee - taxFreeAmount)/11);
        answer = answer == 1 ? 0 : answer;
        return answer;
    }
}
