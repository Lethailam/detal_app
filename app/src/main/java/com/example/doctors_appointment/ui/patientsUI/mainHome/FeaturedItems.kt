package com.example.doctors_appointment.ui.patientsUI.mainHome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doctors_appointment.R
import com.example.doctors_appointment.ui.theme.Indigo400
import com.example.doctors_appointment.ui.theme.Indigo500

// Featured Item

data class Featured(
    val name: String,
    val motivation: String,
    //val specialization: String,
    val image: Painter
)


@Composable
fun FeaturedItems() {

    val featuredItems = listOf(

        Featured(
            name = "Mạnh Toản",
            motivation = "Certificate of Bone Grafting and Sinus Lift Institute of Dentistry and Maxillofacial Training",
            image = painterResource(id = R.drawable.bs1_doctor)
        ),
        Featured(
            name = "Như Dũng",
            motivation = "Areas of expertise: Restoration – Minor Surgery. It is good for health",
            image = painterResource(id = R.drawable.bs2_doctor)
        ),
        Featured(
            name = "Vân Anh",
            motivation = "Doctor with over 15 years of experience specializing in orthodontics. They makes the future of the world",
            image = painterResource(id = R.drawable.female_doctor)
        ),
        Featured(
            name = "Đình Giang",
            motivation = "Graduated from the minimally invasive Full Mouth Implant class organized by Straumman Switzerland",
            image = painterResource(id = R.drawable.bs3_doctor)
        )
    )

    Text(
        text = " Find Your",
        fontFamily = fontActor,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.padding(top = 8.dp)
    )
    Text(
        text = "  Specialist",
        fontFamily = fontInria,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.labelLarge
    )

    LazyRow{
        items(featuredItems.size){
            FeatureCard(featuredItems[it])
        }
    }
}

@Composable
fun FeatureCard(
    featured: Featured
) {

    Box(
        modifier = Modifier
            .height(180.dp)
            .width(320.dp)
            .padding(end = 15.dp, bottom = 9.dp, top = 7.dp)
            .clip(RoundedCornerShape(10))
            .background(Indigo400)
//            .border(2.dp, Indigo500, RoundedCornerShape(10))
    ){
        Box(
            modifier = Modifier
                .height(180.dp)
                .clip(RoundedCornerShape(10))
                .padding(top = 5.dp),
        ){
            Image(
                painter = featured.image,
                contentDescription = "featured image",
                modifier = Modifier.fillMaxSize(),
                alignment = Alignment.BottomEnd,
            )
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, bottom = 10.dp, top = 40.dp, end = 80.dp)
        ) {
            Text(
                text = "Dr. ${featured.name}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontFamily = fontInria,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = featured.motivation,
                color = Color.White,
                fontFamily = fontInria,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 5.dp, end = 50.dp),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )
        }

    }
}
