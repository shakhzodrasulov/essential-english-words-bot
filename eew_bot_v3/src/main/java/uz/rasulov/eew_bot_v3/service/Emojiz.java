package uz.rasulov.eew_bot_v3.service;

import com.vdurmont.emoji.EmojiParser;

/**
 * Created by SHR on 28.01.2022
 */
public enum Emojiz {
    DONE(":white_check_mark:"),
    BOOK(":book:"),
    MUSCLE(":muscle:"),
    POINT_DOWN(":point_down:"),
    SUNGLASSES(":sunglasses:"),
    ARROW_LEFT(":arrow_left:"),
    ENGLAND(":gb:"),
    BOSS(":sunglasses:"),
    CLIENT(":bust_in_silhouette:"),
    WRONG(":x:"),
    NEXT(":fast_forward:"),
    FINISH(":checkered_flag:"),
    BLUE_CHECK(":small_blue_diamond:"),
    GRAY_CHECK(":ballot_box_with_check:"),
    STOP(":no_entry:");


    private final String value;

    Emojiz(String value) {
        this.value = value;
    }

    public String getValue() {
        return EmojiParser.parseToUnicode(value);
    }
}
