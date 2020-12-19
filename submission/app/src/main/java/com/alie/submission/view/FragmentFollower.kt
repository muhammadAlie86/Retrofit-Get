package com.alie.submission.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alie.submission.R
import com.alie.submission.adapter.FollowAdapter
import com.alie.submission.model.User
import com.alie.submission.viewmodel.FollowerViewModel
import kotlinx.android.synthetic.main.fragment_follower.*

class FragmentFollower : Fragment() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var followerAdapter : FollowAdapter
    private lateinit var followerViewModel: FollowerViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_follower, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvFollower)
        recyclerView.setHasFixedSize(true)
        followerViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(FollowerViewModel::class.java)
        showRecyclerView()
        showFollower()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun showRecyclerView(){
        recyclerView.apply {

            layoutManager = LinearLayoutManager(activity)
            followerAdapter = FollowAdapter(activity!!)
            adapter = followerAdapter
        }

    }
    private fun showFollower(){

        val getDataGithubUser = activity?.intent?.getParcelableExtra<User>(DetailActivity.DATA_USER)
        if (getDataGithubUser != null) {

            followerViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(FollowerViewModel::class.java)
            followerViewModel.getFollower(context!!,getDataGithubUser.name,"1")
            followerViewModel.listFollower.observe(viewLifecycleOwner, Observer {
                followerAdapter.setDataFollow(it)
                progressBarFollow.visibility = View.INVISIBLE
            })
            progressBarFollow.visibility = View.VISIBLE
            rvFollower.visibility = View.VISIBLE
        }
    }
}