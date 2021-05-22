package ua.kpi.comsys.io8313.mobiledev.tabs;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import ua.kpi.comsys.io8313.mobiledev.R;

public class CustomGridLayout {
    private Activity activity;
    private View view;
    private ImageView[] imageGrid;
    private LinearLayout[] linearLayoutGrid;
    private int[] heightDimension;
    private int[] widthDimension;

    public ImageView[] getImageGrid() {
        return imageGrid;
    }

    public LinearLayout[] getLinearLayoutGrid() {
        return linearLayoutGrid;
    }

    public int[] getHeightDimension() {
        return heightDimension;
    }

    public int[] getWidthDimension() {
        return widthDimension;
    }

    public class DimensionBuilder {
        private int height;

        DimensionBuilder(int height) {
            this.height = height;
        }

        private int[] buildWidths() {
            DisplayMetrics dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            int x = dm.widthPixels;

            int bigChunk = (int) (x - x / 2.477);
            int midChunk = x / 3 + 360;
            int smallChunk = (bigChunk + 77) / 2;

            return new int[]{smallChunk, smallChunk, smallChunk, smallChunk, midChunk, smallChunk, smallChunk, smallChunk, smallChunk};
        }

        private int[] buildHeights() {
            if (AssetHelper.isPortraitOrientation(activity)) {
                return getHeightDimension(height);
            }

            return getHeightDimension(height + 200);
        }

        private int[] getHeightDimension(int height) {
            int[] dimensionalRow = new int[9];
            for (int i = 0, s = 0; i < dimensionalRow.length; i++, s++) {
                for (int j = i; j <= i; j++) {
                    for (int k = 0; k <= j; k++, i++) {
                        if (i == dimensionalRow.length)
                            break;
                        dimensionalRow[i] = 383;
                        if(i == 4)
                            dimensionalRow[i] = 766;
                    }
                }
            }

            return dimensionalRow;
        }
    }

    public CustomGridLayout(int gridResolution, Activity activity, View view) {
        this.activity = activity;
        this.view = view;
        this.imageGrid = new ImageView[gridResolution];
        this.linearLayoutGrid = new LinearLayout[gridResolution >> 1];
        gridInit();
    }

    private void gridInit() {
        DimensionBuilder dimensionBuilder = new DimensionBuilder(800);
        this.heightDimension = dimensionBuilder.buildHeights();
        this.widthDimension = dimensionBuilder.buildWidths();

        linearLayoutGrid[0] = view.findViewById(R.id.linear_layout1);
        linearLayoutGrid[1] = view.findViewById(R.id.linear_layout2);
        linearLayoutGrid[2] = view.findViewById(R.id.linear_layout3);
        //linearLayoutGrid[3] = view.findViewById(R.id.linear_layout4);
        //linearLayoutGrid[4] = view.findViewById(R.id.linear_layout5);

        imageGrid[0] = view.findViewById(R.id.grid_image1);
        imageGrid[1] = view.findViewById(R.id.grid_image2);
        imageGrid[2] = view.findViewById(R.id.grid_image3);
        imageGrid[3] = view.findViewById(R.id.grid_image4);
        imageGrid[4] = view.findViewById(R.id.grid_image5);
        imageGrid[5] = view.findViewById(R.id.grid_image6);
        imageGrid[6] = view.findViewById(R.id.grid_image7);
        imageGrid[7] = view.findViewById(R.id.grid_image8);
        imageGrid[8] = view.findViewById(R.id.grid_image9);
    }
}
