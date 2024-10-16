package com.plcoding.spotifycloneyt.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.plcoding.spotifycloneyt.data.entities.Song
import com.plcoding.spotifycloneyt.other.Constants.SONG_COLLECTION

class MusicDatabase {

    private val firestore by lazy { FirebaseFirestore.getInstance() }
    private val songCollection by lazy { firestore.collection(SONG_COLLECTION) }

    private val json = """
                {
                  "songs": [
                    {
                      "imageUrl": "https://upload.wikimedia.org/wikipedia/commons/4/4d/Music_logo.png",
                      "mediaId": "1",
                      "songUrl": "https://firebasestorage.googleapis.com/v0/b/melodify-19de9.appspot.com/o/vinee-heights-126947.mp3?alt=media&token=fc7eb889-5631-44d5-bf17-0056cc8d7c59",
                      "subTitle": "Suga playing and singing song",
                      "title": "Travel Song"
                    },
                    {
                      "imageUrl": "https://upload.wikimedia.org/wikipedia/commons/4/4d/Music_logo.png",
                      "mediaId": "1",
                      "songUrl": "https://firebasestorage.googleapis.com/v0/b/melodify-19de9.appspot.com/o/vinee-heights-126947.mp3?alt=media&token=fc7eb889-5631-44d5-bf17-0056cc8d7c59",
                      "subTitle": "Suga playing and singing song",
                      "title": "Travel Song"
                    },
                    {
                      "imageUrl": "https://upload.wikimedia.org/wikipedia/commons/4/4d/Music_logo.png",
                      "mediaId": "1",
                      "songUrl": "https://firebasestorage.googleapis.com/v0/b/melodify-19de9.appspot.com/o/vinee-heights-126947.mp3?alt=media&token=fc7eb889-5631-44d5-bf17-0056cc8d7c59",
                      "subTitle": "Suga playing and singing song",
                      "title": "Travel Song"
                    },
                    {
                      "imageUrl": "https://upload.wikimedia.org/wikipedia/commons/4/4d/Music_logo.png",
                      "mediaId": "1",
                      "songUrl": "https://firebasestorage.googleapis.com/v0/b/melodify-19de9.appspot.com/o/vinee-heights-126947.mp3?alt=media&token=fc7eb889-5631-44d5-bf17-0056cc8d7c59",
                      "subTitle": "Suga playing and singing song",
                      "title": "Travel Song"
                    },
                    {
                      "imageUrl": "https://upload.wikimedia.org/wikipedia/commons/4/4d/Music_logo.png",
                      "mediaId": "1",
                      "songUrl": "https://firebasestorage.googleapis.com/v0/b/melodify-19de9.appspot.com/o/vinee-heights-126947.mp3?alt=media&token=fc7eb889-5631-44d5-bf17-0056cc8d7c59",
                      "subTitle": "Suga playing and singing song",
                      "title": "Travel Song"
                    }
                  ]
                }
"""

    suspend fun getAllSongs(): List<Song> {
        return try {
            val songs: List<Song> = convertJsonToSongs(json)
            return songs
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    data class SongsResponse(
        val songs: List<Song>
    )

    private fun convertJsonToSongs(json: String): List<Song> {
        val gson = Gson()
        val songsResponseType = object : TypeToken<SongsResponse>() {}.type
        val songsResponse: SongsResponse = gson.fromJson(json, songsResponseType)
        return songsResponse.songs
    }
}