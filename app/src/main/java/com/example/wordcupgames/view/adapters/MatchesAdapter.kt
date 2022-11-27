package com.example.wordcupgames.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wordcupgames.R
import com.example.wordcupgames.databinding.LayoutCardGamesBinding
import com.example.wordcupgames.model.Matches
import com.example.wordcupgames.util.formatTo
import com.example.wordcupgames.util.toDate

class MatchesAdapter : ListAdapter<Matches, MatchesAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: LayoutCardGamesBinding = LayoutCardGamesBinding.inflate(
            LayoutInflater.from(parent.context), parent, false,
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: LayoutCardGamesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(match: Matches) = with(binding) {

            val context = root.context

            tvHomeTeam.text = match.homeTeam.name
            tvGuestTeam.text = match.awayTeam.name
            tvHomeTeamScore.text = match.score.fullTime.homeTeam.toString()
            tvAwayTeamScore.text = match.score.fullTime.awayTeam.toString()
            when(match.status) {
                "FINISHED" -> tvMatchTime.text = match.status
                "IN_PLAY" -> tvMatchTime.text = context.getText(R.string.game_in_progress)
                else -> tvMatchTime.text = match.utcDate.toDate()?.formatTo(DATE_FORMAT)
            }
        }

        companion object {
            private const val DATE_FORMAT = "HH:mm"
        }

    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Matches>() {
            override fun areItemsTheSame(oldItem: Matches, newItem: Matches): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Matches,
                newItem: Matches
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}