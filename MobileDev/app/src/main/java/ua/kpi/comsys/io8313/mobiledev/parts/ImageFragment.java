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
