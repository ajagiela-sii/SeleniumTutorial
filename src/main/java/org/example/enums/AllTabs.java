package org.example.enums;

public enum AllTabs {
    ALERTS("https://seleniumui.moderntester.pl/alerts.php"),
    FORM("https://seleniumui.moderntester.pl/form.php"),
    IFRAMES("https://seleniumui.moderntester.pl/iframes.php"),
    TABLE("https://seleniumui.moderntester.pl/table.php"),
    WINDOWTABS("https://seleniumui.moderntester.pl/windows-tabs.php"),
    ACCORDION("https://seleniumui.moderntester.pl/accordion.php"),
    AUTOCOMPLETE("https://seleniumui.moderntester.pl/autocomplete.php"),
    DATAPICKER("https://seleniumui.moderntester.pl/datepicker.php");



    private final String url;

    AllTabs(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
