package com.example.sakezan.utility;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 祝日ユーティリティクラス。
 * 祝日データと祝日判定ロジックを提供。
 */
public class HolidayUtil {
    private static final Set<LocalDate> holidays = new HashSet<>();

    static {
        // 例として2024年の日本の祝日を定義
        holidays.add(LocalDate.of(2024, 1, 1));  // 元日
        holidays.add(LocalDate.of(2024, 1, 8));  // 成人の日
        holidays.add(LocalDate.of(2024, 2, 11)); // 建国記念の日
        holidays.add(LocalDate.of(2024, 2, 12)); // 建国記念の日 振替休日
        holidays.add(LocalDate.of(2024, 3, 20)); // 春分の日
        holidays.add(LocalDate.of(2024, 4, 29)); // 昭和の日
        holidays.add(LocalDate.of(2024, 5, 3));  // 憲法記念日
        holidays.add(LocalDate.of(2024, 5, 4));  // みどりの日
        holidays.add(LocalDate.of(2024, 5, 5));  // こどもの日
        holidays.add(LocalDate.of(2024, 5, 6));  // こどもの日 振替休日
        holidays.add(LocalDate.of(2024, 7, 15)); // 海の日
        holidays.add(LocalDate.of(2024, 8, 11)); // 山の日
        holidays.add(LocalDate.of(2024, 8, 12)); // 山の日 振替休日
        holidays.add(LocalDate.of(2024, 9, 16)); // 敬老の日
        holidays.add(LocalDate.of(2024, 9, 23)); // 秋分の日
        holidays.add(LocalDate.of(2024, 10, 14)); // 体育の日
        holidays.add(LocalDate.of(2024, 11, 3));  // 文化の日
        holidays.add(LocalDate.of(2024, 11, 4));  // 文化の日 振替休日
        holidays.add(LocalDate.of(2024, 11, 23)); // 勤労感謝の日
        holidays.add(LocalDate.of(2024, 12, 23)); // 天皇誕生日
    }

    /**
     * 日付が祝日かどうかを判定する。
     *
     * @param date 判定する日付
     * @return 祝日の場合はtrue、そうでない場合はfalse
     */
    public static boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }
}
