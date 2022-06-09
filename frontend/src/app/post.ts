export interface Post{
    post_id?: Number,
    post_title: String,
    created_at?: Date,
    updated_at?: Date,
    post_content: String,
    // Still not sure how to store images
    post_img?: String
}