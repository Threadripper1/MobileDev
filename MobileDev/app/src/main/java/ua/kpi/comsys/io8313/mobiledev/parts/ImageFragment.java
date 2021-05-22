<<<<<<< HEAD
package ua.kpi.comsys.io8313.mobiledev.parts;

import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ua.kpi.comsys.io8313.mobiledev.resource.Image.ImageGrid;
import ua.kpi.comsys.io8313.mobiledev.resource.Image.ImageSettings;

public class ImageFragment extends Fragment {
    private RecyclerView imageRecyclerView;
    private ImageSettings imageSettings;
    private FloatingActionButton imagePickButton;
    private ImageGrid imageGrid;
    private static TextView noImageTextView;

    public static void setNoImageNotificationInvisiable(){
        noImageTextView.setVisibility(View.INVISIBLE);
    }
}
=======
package ua.kpi.comsys.io8313.mobiledev.parts;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ua.kpi.comsys.io8313.mobiledev.R;
import ua.kpi.comsys.io8313.mobiledev.resource.Image.ImageGrid;
import ua.kpi.comsys.io8313.mobiledev.resource.Image.ImageSettings;

import static android.app.Activity.RESULT_OK;

public class ImageFragment extends Fragment {
    private static final int IMAGE_PICKER = 1;
    private static final int GRID_RESOLUTION = 9 ;
    private RecyclerView imageRecyclerView;
    private ImageSettings imageSettings;
    private FloatingActionButton imagePickButton;
    private ImageGrid imageGrid;
    private static TextView noImageTextView;

    public static void setNoImageNotificationInvisible(){
        noImageTextView.setVisibility(View.INVISIBLE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images, container, false);
        ImageFragment.noImageTextView = view.findViewById(R.id.noImagesYetTextView);
        this.imageRecyclerView = view.findViewById(R.id.imageRecycler);
        this.imagePickButton = view.findViewById(R.id.imagePickerButton);
        this.imagePickButton.setOnClickListener(
                v -> {
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                    startActivityForResult(intent, IMAGE_PICKER);
                }
        );
        this.imageGrid = new ImageGrid(GRID_RESOLUTION);
        imageSettings = new ImageSettings(getContext(), imageGrid, getActivity());
        imageRecyclerView.setAdapter(imageSettings);
        imageRecyclerView.invalidate();

        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_PICKER  && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            imageGrid.addImage(data.getData());
            imageSettings.notifyDataSetChanged();
        }
    }
}
>>>>>>> f951f76 (lab5)
