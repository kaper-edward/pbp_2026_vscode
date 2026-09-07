import java.time.ZonedDateTime;

void main() {
    // TODO: IO.readln()으로 시간대와 두 날짜·시간을 읽는다.
    // TODO: 아래 메서드로 차이, 선후 관계, 뉴욕 시간을 계산하여 출력한다.
}

ZonedDateTime getZonedDateTime(String zone, String dateTimeStr) {
    // TODO: LocalDateTime.parse(), ZoneId.of(), atZone()으로 변환한다.
    return null;
}

void calculateDifference(ZonedDateTime zdt1, ZonedDateTime zdt2) {
    // TODO: 날짜의 전체 일수 차이와 경과 시간의 나머지 시·분·초를 출력한다.
}

void compareTimes(ZonedDateTime zdt1, ZonedDateTime zdt2) {
    // TODO: 더 미래인 날짜·시간을 출력한다.
}

ZonedDateTime convertToNewYork(ZonedDateTime zdt) {
    // TODO: 같은 시점을 America/New_York 시간대로 변환한다.
    return null;
}

String formatDateTime(ZonedDateTime zdt) {
    // TODO: yyyy-MM-dd HH:mm:ss z 형식의 문자열을 반환한다.
    return "";
}
