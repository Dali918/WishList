package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var itemRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Lookup the recyclerview in activity layout




        itemRecyclerView = findViewById<RecyclerView>(R.id.itemRV)
        //create an instance of the adapter
        val itemList = mutableListOf(Item(name="", url = "",price=""))
        // attach the adapter to recycler view by setting its' "adapter" field
        val adapter = ItemAdapter(itemList)
        itemRecyclerView.adapter = adapter
        itemRecyclerView.layoutManager = LinearLayoutManager(this)


        findViewById<Button>(R.id.addButton).setOnClickListener {
            val nameInput = findViewById<EditText>(R.id.nameInput)
            val urlInput = findViewById<EditText>(R.id.urlInput)
            val priceInput  = findViewById<EditText>(R.id.priceInput)
            val item = Item(nameInput.text.toString(),urlInput.text.toString(),priceInput.text.toString())
            itemList.add(item)
            adapter.notifyDataSetChanged()

            nameInput.setText("")
            priceInput.setText("")
            urlInput.setText("")


        }




    }
}

//super.onCreate(savedInstanceState)
//setContentView(R.layout.activity_main)
//// Lookup the recyclerview in activity layout
//val emailRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
////Call getEmails() from the EmailFetcher class and save the results to emails
//val emails=EmailFetcher.getEmails()
////Create an instance of EmailAdapter and pass in the list of emails
//val emailAdapter = EmailAdapter(emails)
////Attach the adapter to recycler view by setting its' "adapter" field
//emailRecyclerView.adapter = emailAdapter
//emailRecyclerView.layoutManager = LinearLayoutManager(this)
//
//findViewById<Button>(R.id.loadMoreBtn).setOnClickListener {
//    // Fetch next 5 emails and display in RecyclerView
//    var moreEmails = EmailFetcher.getNext5Emails()
//    //update the email list to add new emails
//    emails.addAll(moreEmails)
//    //update the adapter
//    emailAdapter.notifyDataSetChanged()
//
//}