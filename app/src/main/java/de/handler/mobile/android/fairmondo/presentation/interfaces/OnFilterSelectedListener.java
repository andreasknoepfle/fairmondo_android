package de.handler.mobile.android.fairmondo.presentation.interfaces;

/**
 * React to filter selections in the {@link de.handler.mobile.android.fairmondo.presentation.fragments.FilterFragment}.
 */
public interface OnFilterSelectedListener {
    /**
     * Informs the implementing activity that the price filter has been selected.
     * @param selection the ste of the switch
     */
    void onPriceFilterSelected(boolean selection);

    /**
     * Informs the implementing activity that the price filter has been selected.
     * @param selection the ste of the switch
     */
    void onAlphabeticalFilterSelected(boolean selection);

    /**
     * Indicates that the fragment should be closed.
     */
    void onFilterFinish();
}