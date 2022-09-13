package org.example.enums;

public enum URLs {
    ALERTS("https://seleniumui.moderntester.pl/alerts.php"),
    FORM("https://seleniumui.moderntester.pl/form.php"),
    IFRAMES("https://seleniumui.moderntester.pl/iframes.php"),
    TABLE("https://seleniumui.moderntester.pl/table.php"),
    WINDOWTABS("https://seleniumui.moderntester.pl/windows-tabs.php"),
    ACCORDION("https://seleniumui.moderntester.pl/accordion.php"),
    AUTOCOMPLETE("https://seleniumui.moderntester.pl/autocomplete.php"),
    DATAPICKER("https://seleniumui.moderntester.pl/datepicker.php"),
    MENU("https://seleniumui.moderntester.pl/menu-item.php"),
    MODAL_DIALOG("https://seleniumui.moderntester.pl/modal-dialog.php"),
    PROGRESSBAR("https://seleniumui.moderntester.pl/progressbar.php"),
    SELECT_MENU("https://seleniumui.moderntester.pl/selectmenu.php"),
    SLIDER("https://seleniumui.moderntester.pl/slider.php"),
    TOOLTIP("https://seleniumui.moderntester.pl/tooltip.php"),
    DRAGGABLE("https://seleniumui.moderntester.pl/draggable.php"),
    DROPPABLE("https://seleniumui.moderntester.pl/droppable.php"),
    RESIZABLE("https://seleniumui.moderntester.pl/resizable.php"),
    SELECTABLE("https://seleniumui.moderntester.pl/selectable.php"),
    SORTABLE("https://seleniumui.moderntester.pl/sortable.php"),
    HIGHSITE("https://seleniumui.moderntester.pl/high-site.php");


    private final String url;

    URLs(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
