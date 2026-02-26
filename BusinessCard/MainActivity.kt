package com.example.businesscardapp



import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PremiumBusinessCard()
        }
    }
}

@Composable
fun PremiumBusinessCard() {

    // 💜 Purple Gradient Background
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFEDE7F6), // Light purple
            Color(0xFF7E57C2)  // Deep purple
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Push card to center
            Spacer(modifier = Modifier.weight(1f))

            // 🪪 Profile Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(12.dp, RoundedCornerShape(24.dp)),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {

                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Profile Image
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Name
                    Text(
                        text = "Hazle",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    // Role
                    Text(
                        text = "Android Developer",
                        fontSize = 18.sp,
                        color = Color(0xFF7E57C2),
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            // Push contact section to bottom
            Spacer(modifier = Modifier.weight(1f))

            //  Contact Details
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                Divider(thickness = 1.dp, color = Color.LightGray)

                ContactRow(Icons.Default.Phone, "+91 123456789")
                ContactRow(Icons.Default.Email, "hazle@gmail.com")
                ContactRow(Icons.Default.Place, "abx, xyz")
            }
        }
    }
}

//Contact Row Component
@Composable
fun ContactRow(icon: ImageVector, text: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = Color(0xFF7E57C2),
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.DarkGray
        )
    }
}


// 👀 PREVIEWS


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        PremiumBusinessCard()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun BusinessCardDarkPreview() {
    MaterialTheme {
        PremiumBusinessCard()
    }
}
