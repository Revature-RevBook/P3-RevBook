export interface VotePost {
    voteId: Number,
    createdAt: Date,
    updatedAt: Date,
    vote: number,
    postId: Number,
    voterId: Number
}