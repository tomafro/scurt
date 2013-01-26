(ns scurt.test.web.links
  (:use [midje.sweet]
        [scurt.web.links]))

(facts "open"
  (fact "redirects to the url of the link"
    (open ...key...) => {:status 302, :headers {"Location" "http://example.com/path"}}
    (provided (scurt.models.link/find-link ...key...) => {:url "http://example.com/path"}))
  (fact "responds with 404 if the link doesn't exist"
    (open ...key...) => {:status 404}
    (provided (scurt.models.link/find-link ...key...) => nil)))
